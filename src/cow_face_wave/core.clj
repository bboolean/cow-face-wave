(ns cow-face-wave.core
  (:gen-class))

(defn make-line [number]
  (as-> number $
    (Math/sin $)
    (* 20 $)
    (+ 20 $)
    (Math/round $)
    (range $)
    (map (fn [_] (str " ")) $)
    (clojure.string/join "" $)
    (str "   " $ "🐮")))

(defn print-loop [number]
  (do
    (println (make-line number))
    (Thread/sleep 50)
    (print-loop (+ number 0.2))))

(defn -main
  "Print out cow faces in a sinusoidal fashion"
  [& args]
  (print-loop 0))
