(ns name-gen.models.gen)

(defn generate []

  (let [adjectives ["rapid" "alluring" "exotic" "raunchy"]
        nouns ["elephant" "tiger" "octopus" "cat" "rhino" "rabbit"]]

       (str (rand-nth adjectives) " " (rand-nth nouns))))
