(ns intro.representingdata
  (:require [incanter.core]))

(def first-name "jeff")
(def height-cm 188.2)
(def number-sons 1)
(def teaching-coursera true)
(def heights [188.2 181.3 193.4])
(def first-names ["jeff" "roger" "andrew" "brian"])

;; R's lists look a lot like a map to me. 
(def my-map {:heights heights :first-names first-names})

(def my-matrix (matrix [1 2 3 4] 2))

;; Datasets appear to be equivalent to R's data frame, except they
;; have transposed args. I've probably missed a trick in the
;; partition, interleave thing. 
(def my-dataset (dataset ["heights" "first-names"]
                         (partition 2 (interleave
                                       [188.2 181.3 193.4 192.3]
                                       ["jeff" "roger" "andrew" "brian"]))))

(def smoker ["yes" "no" "yes" "yes"])
(def smoker-factor (categorical-var :data smoker))

(def some-missing [188.2 181.3 193.4 nil])

(map nil? some-missing)

;; Subsetting.
;; N.B. R is 1-indexed, like it's 1988. 
(def heights4 (conj heights 192.3))
(heights4 0)
(map heights4 [0 1 3])

(sel my-dataset :rows 0)
(sel my-dataset :cols "first-names")

;; having to use positionals in filter is pretty vile. There should be
;; a way that presents the filter with a map keyed by column names. 
(sel my-dataset :filter #(= (second %) "jeff"))
(sel my-dataset :filter #(< (first %) 190.0))


