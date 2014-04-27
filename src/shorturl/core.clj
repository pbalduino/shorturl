(ns shorturl.core
  (:require [ring.util.response :as response]
            [shorturl.views :as v]
            [shorturl.db    :as m]))

(defn root []
  (v/layout v/root-body))

(defn not-found []
  (v/layout #(v/not-found)))

(defn redirect [id]
  (if-let [url (m/find-by-id id)]
    (response/redirect url)
    (response/not-found (not-found))))

(defn show [id]
  (if-let [url (m/find-by-id id)]
    (v/layout #(v/show id url))
    (response/not-found (not-found))))

(defn add [url]
  (if-let [id (m/find-by-url url)]
    1 2))