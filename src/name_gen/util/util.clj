(ns name-gen.util.util
  (require [net.cgrand.enlive-html :as html]))

(defn fetch-url [url]
  (html/html-resource (java.net.URL. url)))

(defn filter-plurals-and-suffixes [s] (not (or (.endsWith s "t") (.startsWith s "-"))))

(defn fetch-to-list [url selector]
  (map html/text (html/select (fetch-url url) selector)))

(defn fetch-to-vector
  ([url selector] 
     (vec (fetch-to-list url selector)))

  ([url selector filter-pred]
     (vec (filter filter-pred (fetch-to-list url selector)))))


