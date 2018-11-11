(ns lattes-xml.merge-map
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

(def oxygen1-xsd "/Users/eklavya/projects/code/lattes-xml/_scratch/oxygen1.xsd")




(def xml-tree
  (xml/parse oxygen1-xsd))



(-> xml-tree
    :content
    first
    :content
    first
    :content
    first
    :content
    first
    :attrs)




