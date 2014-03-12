(ns name-gen.models.gen)

(defn generate [adjectives nouns]
  (str (rand-nth adjectives) " " (rand-nth nouns)))
