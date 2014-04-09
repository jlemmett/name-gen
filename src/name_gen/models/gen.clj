(ns name-gen.models.gen)

(defn generate
  ([adjectives nouns]
     [(rand-nth adjectives) (rand-nth nouns)]) 
  
  ([adjectives nouns max-len]
     {:pre [(< 6 max-len)]}
     (let [name-stream (repeatedly #(generate adjectives nouns))]
      (first (drop-while (fn [[a b]] (> (+ (count a) (count b)) max-len)) name-stream)))))




