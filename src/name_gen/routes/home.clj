(ns name-gen.routes.home
  (:require [compojure.core :refer :all]
            [name-gen.views.layout :as layout]
            [name-gen.models.gen :as gen]))

(defn home []
  (layout/common [:h1 (gen/generate)]))

(defroutes home-routes
  (GET "/" [] (home)))
