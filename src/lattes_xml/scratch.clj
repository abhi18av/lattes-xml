(ns lattes-xml.scratch
  (:require  [clojure.data.xml :as dxml]
             [clojure.xml :as xml]
             [clojure.data.zip.xml :as dzip-xml]
             [xml-in.core :as xml-in]
             [clojure.java.io :as io]
             [cuerdas.core :as cuerdas]
             [clojure.zip :as zip]
             [clojure.data.zip :as dzip]
             [clojure.pprint :as pprint]
             [clojure.core.reducers :as reducers]
             [clojure.walk :as walk]
             [com.rpl.specter :as specter]))

(def lattes-xsd "./_scratch/lattes.xsd")

(def xml-tree
  (xml/parse lattes-xsd))

(xml/parse "/Users/eklavya/projects/code/lattes-xml/_scratch/lattes.xsd")


(->
 (:content (xml/parse "/Users/eklavya/projects/code/lattes-xml/_scratch/lattes.xsd"))
 count)




;; TODO: Deal only with << Dados Gerais >> first.
;; NOTE: need to create a proper map of dados gerais by replacing all << refs >> with actual values


(map :attrs
     (:content (xml/parse "/Users/eklavya/projects/code/lattes-xml/_scratch/dados-gerais.xsd"))
)







