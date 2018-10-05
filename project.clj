(defproject hstop1k "0.1.0-SNAPSHOT"
  :description "A search and display application for Q-Dance Harder Styles Top
               1000 songs"
  :url "https://github.com/terop/env-logger"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [enlive "1.1.6"]
                 [korma "0.4.3"]
                 [org.xerial/sqlite-jdbc "3.25.2"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [selmer "1.12.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler hstop1k.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
