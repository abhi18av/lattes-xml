;; NOTE: https://github.com/cbracco/html5-test-page
;; TODO: create a separate repo for the enlive tutorial with this page
;; TODO: render the html5 page with hiccup

(ns lattes-xml.scratch-html-test-page
  (:require [net.cgrand.enlive-html :as html]
            [clojure.pprint :as pprint]))

(def sample-html
  (slurp  "/Users/eklavya/projects/code/lattes-xml/src/lattes_xml/html5-test-page.html"))

(def parsed-html (html/html-resource (java.io.StringReader. sample-html)))

;;;;;;;;;;;;;;;
;; enlive-html
;;;;;;;;;;;;;;;

html/*options*
html/add-class
html/after
html/alter-ns-options!
html/annotate
html/any
html/any-node
html/append
html/append!
html/as-nodes

;;;;;


(html/at parsed-html
    [:head] (html/substitute new-content)
    [:body] (html/substitute new-content))

;;;;;

html/at*
html/attr-contains
html/attr-ends
html/attr-has
html/attr-starts
html/attr-values
html/attr=
html/attr?
html/attr|=
html/before
html/but
html/but-node
html/cacheable
html/cacheable?
html/clone-for
html/comment-node
html/content
html/defsnippet
html/defsnippets
html/deftemplate
html/do->
html/emit*
html/emit-tag
html/even
html/first-child
html/first-of-type
html/flatmap
html/flatten-nodes-coll
html/fragment-selector?
html/get-resource
html/has
html/has-class
html/html
html/html-content
html/html-resource
html/html-snippet
html/id=
html/intersection
html/last-child
html/last-of-type
html/left
html/lefts
html/let-select
html/lockstep-transform
html/lockstep-transformation
html/move
html/node-selector?
html/ns-options
html/nth-child
html/nth-last-child
html/nth-last-of-type
html/nth-of-type
html/odd
html/only-child
html/only-of-type
html/pred
html/prepend
html/re-pred
html/register-resource!
html/remove-attr
html/remove-class
html/replace-vars
html/replace-words
html/right
html/rights
html/root

;;;;

(html/select parsed-html [:tfoot])

(html/select parsed-html [:p])

(html/select parsed-html [:p :label]) ; NOTE: :p.label or :p#label didnt' work

(html/select parsed-html [:p :label.error])

(html/select parsed-html [:ul])

(html/select parsed-html [:#forms__radio])

(html/select parsed-html [(html/attr= :type "submit")])

(html/select parsed-html [:fieldset (html/attr= :for "in")])

;; AND relationship betweeen selectors


(html/select parsed-html [[:input (html/attr= :name "checkbox")]])

;; OR relationship betweeen selectors

(pprint/pprint (html/select parsed-html [#{:select (html/attr= :name "checkbox")}]))

;;;;
html/select-fragments*
html/select-nodes*
html/self-closing-tags
html/set-attr
html/set-ns-options!
html/set-ns-parser!
html/snippet
html/snippet*
html/sniptest
html/sniptest*
html/strict-mode
html/strict-mode*
html/substitute
html/tag=
html/template
html/text
html/text-node
html/text-pred
html/texts
html/this-node

;;;;


(def new-content '({:tag :p, :content ("Hello, World!")}))

(html/transform parsed-html [:header :h1] identity) ;; changes nothing


(html/transform parsed-html [:header :h1] (html/content new-content))

(html/transform parsed-html [:header :h1]
                (html/content "Say it!"
                         [[[new-content]]]  ; <== wrapped
                         "Say it again!"
                         new-content))


(html/transform parsed-html [:header] (html/append new-content))



(html/transform parsed-html [:div#wrapper]
           (wrap :div
                 {:id "superdiv", :class "wasted space"})))


(transform parsed-html [:div#wrapper] unwrap)



(transform parsed-html [:div#wrapper]
                  (set-attr :NEWBIE "FRED", :OLDIE "DAWN"))


(transform parsed-html [:div#wrapper]
                   (remove-attr :id))


(transform parsed-html [:div#wrapper]
                   (add-class "highlight" "plain-styled"))

;;;;

html/transform-content
html/transformation
html/union
html/unwrap
html/void
html/whitespace
html/with-options
html/wrap
html/xml-parser
html/xml-resource
html/zip-pred
html/zip-select
html/zip-select-fragments*
html/zip-select-nodes*

;;;;;;;;;;;;;;;
;; enlive-reload
;;;;;;;;;;;;;;;

html/declare-dependency
html/refresh
html/reload-ns
html/stale-dep?
html/stale-ns?

;;;;;;;;;;;;;;
;; reload
;;;;;;;;;;;;;;

html/auto-reload
html/watch-url

;;;;;;;;;;;;;;
;; xml
;;;;;;;;;;;;;;

html/attrs
html/comment?
html/content
html/dtd?
html/element
html/parse
html/startparse-sax
html/tag
html/tag?
html/xml-zip

;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;
;; SELECTORS
;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;
;; TRANSFORMERS
;;;;;;;;;;;;;;;
