(ns name-gen.routes.home
  (:require [compojure.core :refer :all]
            [name-gen.views.layout :as layout]
            [name-gen.models.gen :as gen]
            [name-gen.data.data :as data]))

(defn as-link [[adjective noun]]
  (let [wiktionary-url "http://fi.wiktionary.org/wiki/"
        wikipedia-url "http://fi.wikipedia.org/wiki/"]

    (list [:a {:href (str wiktionary-url adjective) :target "_blank"} adjective]
          :&nbsp
          [:a {:href (str wikipedia-url noun) :target "_blank"} noun])))

(defn home
  ([] (home -1))
  ([max-len]

     (let [name (if (< 6 max-len)
                  (gen/generate data/adjectives-fi data/animals-fi max-len)
                  (gen/generate data/adjectives-fi data/animals-fi))]
       
       (layout/common (list
                       [:h1 (as-link name)]
                       [:br] [:br] [:br]
                       [:h5 [:a {:href "http://github.com/jlemmett/name-gen"
                                 :target "_blank"} "GitHub"]]
                       [:h5 [:a {:href "http://twitter.com/jlemm"
                                 :target "_blank"} "@jlemm"]])))))



(defroutes home-routes
  (GET "/" [] (home))
  (GET "/:max-len" [max-len] (home (Integer/parseInt  max-len))))
