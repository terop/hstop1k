(defproject hstop1k "0.1.0-SNAPSHOT"
  :description "A search and display application for Q-Dance Harder Styles Top
               1000 songs"
  :url "https://github.com/terop/env-logger"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [enlive "1.1.5"]
                 [korma "0.4.0"]
                 [org.xerial/sqlite-jdbc "3.8.7"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.3"]
                 [de.ubercode.clostache/clostache "1.4.0"]
                 [org.clojure/data.json "0.2.5"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler hstop1k.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
