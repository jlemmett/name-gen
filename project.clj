(defproject name-gen "0.2.0-SNAPSHOT"
  :description "version name generator 0.2.0 'ahdasmielinen lammas'"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [enlive "1.1.5"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler name-gen.handler/app
         :init name-gen.handler/init
         :destroy name-gen.handler/destroy}
  :aot :all
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.1"]]}})
