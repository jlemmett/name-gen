(ns name-gen.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common [& body]
  (html5
    [:head
     [:title "name-gen 0.3.1 (rela ilves)"]
     (include-css "/css/screen.css")]
    [:body body]))
