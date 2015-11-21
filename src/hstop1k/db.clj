(ns hstop1k.db
  (:require [korma.core :as kc]
            [korma.db :as kd]))

;; The korma DB reference
(kd/defdb db
  (kd/sqlite3 {:db "data.db"}))

;; The database entity for the songs table
(kc/defentity songs
  (kc/table :songs)
  (kc/entity-fields :place :artist :song))

(defn insert-row
  "Inserts one row to the songs table"
  [place artist song]
  (kc/insert songs
             (kc/values {:place place
                         :artist artist
                         :song song})))

(defn select-songs
  "Returns all the songs in the DB as a vector of maps"
  []
  (vec (kc/select songs
                  (kc/order :place :ASC))))
