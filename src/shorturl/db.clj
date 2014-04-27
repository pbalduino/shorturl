(ns shorturl.db
  (:require [clojure.java.jdbc :as j]))

(defonce conn {:subprotocol "postgresql"
               :subname "//localhost:5432/shorturl"
               :user "shorturl"
               :password "shorturl"})

(defn find-by-id [id]
  (j/with-db-connection [conn conn]
      (some-> conn
              (j/query ["select full_url from url where short_url = ?" id])
              first
              :full_url)))

(defn find-by-url [url]
  url)