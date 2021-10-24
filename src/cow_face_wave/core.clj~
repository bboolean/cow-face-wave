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
