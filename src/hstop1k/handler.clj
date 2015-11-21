(ns hstop1k.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [selmer.parser :refer [render-file]]
            [hstop1k.db :as db]))

(defroutes app-routes
  (GET "/" [] (render-file "templates/index.html"
                           {:songs (db/select-songs)}))
  (route/not-found "404 Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
