(ns heraldry.core-test
  (:require [clojure.test :refer :all]
            [heraldry.core :refer :all]))

(def tiercedInPale "tierced in pale gules, argent, or")
(def tiercedInPale2 "tierced in pale gules, argent, and or")
(def tip3 "tierced in pale gules, argent, and or a annulet vert")
(def SirBellias "Vert, a bell or")
(def uther "Vert, two dragons segreant addorsed or")
(def madoc "Per pale vert and or, two dragons segreant addorsed all countercharged")

(def tiercedInPaleWith "tierced in pale gules, argent, and or a cinquefoil sable")

(def threeStar "tierced in pale gules, argent and azure A mullet azure in dexter chief A mullet gules in middle chief A mullet argent in sinister chief")

(deftest shouldAllowGulesAsValidColor
  (testing "FIXME, I fail."
    (is 5)))


