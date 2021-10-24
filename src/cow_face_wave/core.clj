(ns cow-face-wave.core
  (:gen-class))

(def number (atom 0))

(defn makeln [a]
  (as-> a $
    (Math/sin $)
    (* 10 $)
    (+ 10 $)
    (Math/round $)
    (range $)
    (map (fn [a] (str " ")) $)
    (clojure.string/join " " $)
    (str "   " $ "🐮")))

(defn print-loop []
  (do
    (println (makeln @number))
    (swap! number #(+ %1 0.2))
    (Thread/sleep 50)
    (print-loop)))

(defn -main
  "Print out cow faces in a sinusoidal way"
  [& args]
  (print-loop))


;;;


(defn inc-count [ch count a]
  (println [ch count a])
  (if (= ch a) (inc count) count))

(defn reduce-thing [text-list ch]
  (reduce (partial inc-count ch) 0 text-list))

;; (defn count-thing [text-list ch]
;;   (count (reduce text-list ch)))

(defn get-char [text ch]
  (if (<= (reduce-thing text ch) 1)
    "("
    ")"))

;; (get-char (clojure.string/split "ttte" #"") "e")

(defn split-chars [a]
  (clojure.string/split a #""))

(defn replace-chars [a]
  (let [b (split-chars a)]
        (map (partial (split-chars b)) b)))

(defn encode-dups [text]
    (clojure.string/join "" (replace-chars text)))

;; (encode-dups "recede")

;; (count (re-seq #"3" "3333a3"))





