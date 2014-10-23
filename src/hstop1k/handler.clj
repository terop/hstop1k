(ns hstop1k.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clostache.parser :refer [render]]
            [hstop1k.db :as db]))

;; Template Rendering
(defn read-template
  "Reads a template with the provided name."
  [template-name]
  (slurp (clojure.java.io/resource (str "templates/" template-name
                                        ".mustache"))))

(defn render-template
  "Renders the template name with the provided parameters."
  [template-file params]
  (render (read-template template-file) params))

(defroutes app-routes
  (GET "/" [] (render-template "index"
                               {:songs (db/select-songs)}))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
