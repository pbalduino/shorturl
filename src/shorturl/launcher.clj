(ns shorturl.launcher
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [shorturl.handler :refer [app]])
  (:gen-class))

(defn -main [& args]
  (run-jetty app {:port 8001}))