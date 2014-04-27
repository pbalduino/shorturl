(defproject shorturl "0.1.0"
  :description "URL shorter made in Clojure"
  :url "http://pbaldu.in/"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"
            :distribution :repo}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [org.clojure/java.jdbc "0.3.3"]
                 [org.postgresql/postgresql "9.3-1100-jdbc4"]
                 [ring "1.2.2"]
                 [bk/ring-gzip "0.1.1"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler shorturl.handler/app}
  :aot :all
  :main shorturl.launcher)
