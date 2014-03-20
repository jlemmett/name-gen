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

(defn home []
  (layout/common (list
                  [:h1 (as-link (gen/generate data/adjectives-fi data/animals-fi))]
                  [:br] [:br] [:br]
                  [:h5 [:a {:href "http://github.com/jlemmett/name-gen"
                            :target "_blank"} "GitHub"]]
                  [:h5 [:a {:href "http://twitter.com/jlemm"
                            :target "_blank"} "@jlemm"]]

                  )))



(defroutes home-routes
  (GET "/" [] (home)))
