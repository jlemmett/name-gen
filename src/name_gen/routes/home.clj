(ns name-gen.routes.home
  (:require [compojure.core :refer :all]
            [name-gen.views.layout :as layout]
            [name-gen.models.gen :as gen]
            [name-gen.data.data :as data]))

(defn home []
  (layout/common [:h1 (gen/generate data/adjectives-fi data/animals-fi)]))

(defroutes home-routes
  (GET "/" [] (home)))
