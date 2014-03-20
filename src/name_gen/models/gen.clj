(ns name-gen.models.gen)

(defn generate [adjectives nouns]
  [(rand-nth adjectives) (rand-nth nouns)])
