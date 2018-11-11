;; NOTE: https://github.com/cbracco/html5-test-page

(ns lattes-xml.scratch-html-test-page
  (:require [net.cgrand.enlive-html :as html]
            [clojure.pprint :as pprint]))

(def sample-html
 (slurp  "/Users/eklavya/projects/code/lattes-xml/src/lattes_xml/html5-test-page.html"))



(def parsed-html (html/html-resource (java.io.StringReader. sample-html)))


(:tag parsed-html)

