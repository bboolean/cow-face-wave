(defproject cow-face-wave "0.1.0-SNAPSHOT"
  :description "Print out cow faces in a sinusoidal fashion"
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot cow-face-wave.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
