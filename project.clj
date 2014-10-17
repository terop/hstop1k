(defproject hstop1k "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/terop/env-logger"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [enlive "1.1.5"]
                 [korma "0.4.0"]
                 [org.xerial/sqlite-jdbc "3.8.6"]]
  :main ^:skip-aot hstop1k.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
