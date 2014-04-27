(ns shorturl.views
  (:use [hiccup.page]))

(defn layout [body]
    (html5 {:lang "en-BR"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
      (include-css "/stylesheets/bootstrap.min.css")
;      (include-css "/stylesheets/application.css")
      [:title "pbaldu.in URL shorter"]]
    [:body
      [:div {:class "container"}
        [:div {:class "page-header"}
          [:h1 "URL Shorter"]]]
      [:div {:class "container"}
        (body)]]))

(defn root-body []
  [:div {:class "row"}
    [:h2 "What"]
    [:div {:class ".col-md-12"}
      [:p 
        [:a {:href "/"} "pbaldu.in"] 
        " is a lightweight URL shorter for personal use. That's why it has my name."]
      [:p "It's also an application to learn more about Clojure and web application deployment."]
      [:hr]
      [:h2 "How"]
      [:p "Soon I'll publish a guide for the API. I'm planning to develop bookmarlets and mobile applications to ease my life."]
      [:hr]
      [:h2 "Why"]
      [:p "I hate ads, spam and third party cookies and I don't trust Google to save my bookmarks. "
          "Also I thought it would be cool to have URLs with my name."]]])

(defn not-found []
  [:div {:class "row"}
    [:div {:class "center-block"}
      [:p (str "The address you're looking for was removed or does not exist")]
      [:img {:src "/images/404.jpg" :class "img-responsive"}]]])

(defn show [id url]
  (let [id (str "http://pbaldu.in/" id)]
    [:div {:class "row"}
      [:p "O endereço "
        [:a {:href id} id] " vai te redirecionar para " 
        [:a {:href url} url]]]))