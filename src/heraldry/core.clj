(ns heraldry.core
  (:require [instaparse.core :as insta]        )
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(insta/set-default-output-format! :enlive)

(def as-and-bs
  (insta/parser
    "S = AB*
     AB = (A B) | (B A)
     A = 'a'+
     B = 'b'+"))

(defn show[tree]
  (insta/visualize tree))


(def heraldry
  (insta/parser
   "S = FIELD | ((DIVISION2 | DIVISION3) [CHARGE])
    FIELD = color [CHARGE]
    DIVISION2 = (perPale | quertely | perPall | perChevron) SEP color SEP color
    DIVISION3 = tiercedInPale SEP color SEP color SEP color
    CHARGE = (<ASEP> DEVICE SEP color) | (<space> COUNT <space> DEVICE <space> (color | counter ))
    COUNT = (#'\\d+' | #'2[01]' | #'1\\d' | #'(?i)one' | #'(?i)two' | #'(?i)three' | #'(?i)four' | #'(?i)five' | #'(?i)six' | #'(?i)seven' | #'(?i)eight' | #'(?i)nine' | #'(?i)ten')
    DEVICE = SHAPE | (BEAST [<space> ATTITUDE])
    SHAPE = (bezant | crescent | lozenge | annulet | billet | mullet | bell)
    BEAST =  dragon
    ATTITUDE = #'(?i)addorsed' | #'(?i)combatant'
    <ASEP> = <space> | <an_a>
    <SEP> = <space> | <and>
    <an_a> = <#'(?i)[,\\s]+a\\s+'>
    <space> = <#'[, ]+'>
    <and> =  <#'(?i)[,\\s]+and\\s+'>
    counter = #'(?i)all\\s+countercharged'
    color = #'(?i)gules' | #'(?i)or' | #'(?i)argent' | #'(?i)vert'
    perPale = #'(?i)Per\\s+Pale'
    quertely = #'(?i)Quartely'
    tiercedInPale = #'(?i)Tierced\\s+in\\s+Pale'
    perPall = #'(?i)Per\\s+Pall'
    perChevron = #'(?i)Per\\s+Chevron'
    bell = #'(?i)bell'
    bezant = #'(?i)bezant'
    dragon = #'(?i)dragon'  <[#'[Ss]']> <space> #'(?i)segreant'
    mullet = #'(?i)mullet'
    crescent = #'(?i)crescent'
    lozenge = #'(?i)lozenge'
    billet  = #'(?i)billet'
    annulet = #'(?i)annulet'"))

(heraldry heraldry.core-test/madoc)
(insta/visualize (heraldry heraldry.core-test/madoc))

  

(def color
  (insta/parser
   "S = COLOR
    COLOR = OR | GULES
    GULES = #'(?i)gules'
    OR = #'(?i)or'"
   :output-format :enlive))

(def ordinary
  (insta/parser
   "S = ORDINARY
    ORDINARY = BEND | PerPale | Quertely
    PerPale = #'(?i)Per\\s+Pale'
    Quertely = #'(?i)Quertely'
    BEND = #'(?i)a bend'"))


(def divisionsOfField
 "ORDINARY = BEND | PerPale | Quertely | TiercedInPale | PerPall | PerChevron | Barry | PerFess | Paly | PerPile | Gryonny
    PerPale = #'(?i)Per\\s+Pale'
    Quertely = #'(?i)Quartely'
    TiercedInPale = #'(?i)Tierced\\s+in\\+Pale'
    PerPall = #'(?i)Per\\s+Pall'
    PerChevron = #'(?i)Per\\s+Chevron'
    Barry = #'(?i)Barry'
    PerFess  = #'(?i)Per\\s+Fess'
    Paly  = #'(?i)Paly'
    PerPile  = #'(?i)Per\\s+Pile'
    Gryonny  = #'(?i)Gryonny'
    BEND = #'(?i)a bend'")




  
