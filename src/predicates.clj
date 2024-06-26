(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (> n k)))

(defn equal-to [n]
  (fn [k] (== n k)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string) (nil? string) (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true? (map #(has-award? book %) awards)))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (if (empty? filtered)
      false
      (pred (first filtered)))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n] 
(loop [x 2]
  (cond
    (= x n) true
    (= (mod n x) 0) false
    :else (recur (inc x)))))

;^^
