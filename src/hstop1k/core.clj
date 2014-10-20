(ns hstop1k.core
  (:require [net.cgrand.enlive-html :as html]
            [hstop1k.db :as db])
  (:gen-class))

;; Track handling functions
(defn fetch-url
  "Fetches the page source pointed to by the given URL"
  [url]
  (html/html-resource (java.net.URL. url)))

(defn lseq-value
  "Returns the wrapped value of an lazy seq of length one"
  [lseq]
  ((vec lseq) 0))

(defn process-url
  "Processes a given URL, that is, adds all songs on page to the database"
  [url]
  (doseq [row (html/select (fetch-url url) [:tbody :tr])]
    (let [tds (vec (for [item (:content row) :when (= (:tag item) :td)]
                     (:content item)))]
      ;; Order: 0: place, 1: artist, 2: song
      (db/insert-row (Integer/parseInt (lseq-value (tds 0)))
                     (lseq-value (tds 1))
                     (lseq-value (tds 2))))))

(defn insert-from-urls
  "Inserts all tracks from the list of provided URLs"
  [urls]
  (doseq [url urls]
    (process-url url)))

(defn -main
  "The main function (currently)"
  [& args]
  (insert-from-urls ["http://www.q-dance.com/harderstylestop1000/2014/list/1000-901"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/900-801"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/800-701"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/700-601"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/600-501"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/500-401"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/400-301"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/300-201"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/200-101"
                     "http://www.q-dance.com/harderstylestop1000/2014/list/100-001"]))
