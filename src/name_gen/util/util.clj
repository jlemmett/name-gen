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


(defn gen-numbers [start end step]
  (take-while #(<= % end) (iterate #(+ % step) start)))

(defn gen-sanakirja-urls []
  (let [baseUrl "http://www.sanakirja.org/cat.php?id=4&l=17&start="
        startParameters (gen-numbers 100 8200 100)]

    (map #(str baseUrl %) startParameters)))

(defn get-sanakirjaorg-words [url]
  (fetch-to-list url [:.category :li]))

(defn get-sanakirjaorg-words-test [url]
  '(url url))

(defn get-all-sanakirjaorg-words [urls]

  (reduce (fn [allWords url] (concat allWords (get-sanakirjaorg-words url))) [] urls))

;; (def all-sanakirja-adjectives (get-all-sanakirjaorg-words (gen-sanakirja-urls)))

;; http://www.sanakirja.org/cat.php?id=4&l=17&start=100
;; http://www.sanakirja.org/cat.php?id=4&l=17&start=200
;; ..
;; http://www.sanakirja.org/cat.php?id=4&l=17&start=8200

;; TODO: Fetch all of the above programatically


