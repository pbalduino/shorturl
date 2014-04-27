(ns shorturl.handler
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.middleware :refer [wrap-base-url]]
            [ring.middleware.file :refer [wrap-file]]
            [ring.middleware.gzip :refer [wrap-gzip]]
            [shorturl.core :as core])
  (:gen-class))

(defroutes app-routes
  (route/resources "/")
  (GET "/"      []   (core/root))
  (GET "/!/:id" [id] (core/show id))
  (GET "/:id"   [id] (core/redirect id))
  (GET ["/+/:url", :url #".*"] [url] (core/add url))
  (route/not-found core/not-found))

(def app
  (-> (handler/site app-routes)
      wrap-base-url
      wrap-gzip
      ))