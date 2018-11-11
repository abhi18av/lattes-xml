(ns lattes-xml.scratch-enlive
  (:require [net.cgrand.enlive-html :as html]
            [clojure.pprint :as pprint])
  )



(def layout-html

  "
<!DOCTYPE html>
<html>
<head>
<title>Critter4Us</title>
  <link href=\"/css/reset.css\" rel=\"stylesheet\" type=\"text/css\">
  <script src=\"/js/jquery.js\" type=\"text/javascript\"></script>
  <script src=\"/js/c4.js\" type=\"text/javascript\"></script>
  <script id=\"jquery_code\" type=\"text/javascript\">
<!--jquery-->
</script>
</head>
<body>
  <div id=\"wrapper\">
<!--body-->
</div>
</body>
</html>
")


(def application-html
  "<!DOCTYPE html>
  <html lang=\"en\">
  <head>
  <title>This is a title placeholder</title>
  </head>
  <body>
  <ul>
  <li>first list</li>
  <li>second list</li>
  </ul>
  </body>
  </html>"
)


(def parsed-application-html (html/html-resource (java.io.StringReader. application-html)))

(html/select parsed-application-html [:body])



(def parsed-layout-html (html/html-resource (java.io.StringReader. layout-html)))

(html/select parsed-layout-html [:body])





(pprint/pprint
 (html/select parsed-layout-html [:div])
 )




(html/select parsed-layout-html [:#wrapper])

(pprint/pprint (html/select parsed-layout-html [:div#wrapper]))


(def page-content '({:tag :p, :content ("Hi, mom!")}))


(pprint/pprint (html/transform parsed-layout-html
                   [:div#wrapper]
                   (fn [a-selected-node]
                     (assoc a-selected-node :content page-content))))


(pprint/pprint (html/transform parsed-layout-html
                   [:#wrapper]
                   (html/content
                    "Say it!"
                    [[[page-content]]]  ; <== wrapped
                    "Say it again!"
                    page-content)))



(pprint/pprint
 (html/transform parsed-layout-html [:#wrapper]
            (html/append page-content)))


(pprint (at layout
            [:head] (substitute page-content)
            [:body] (substitute page-content)))


(pprint (transform layout [:div#wrapper]
                   (wrap :div
                         {:id "superdiv", :class "wasted space"})))

;;;;;;;;


(def herd-html
"
  <form action=\"/herd_changes\" method=\"post\" id=\"animal_addition_form\">
    <table>
        <tr class=\"per_animal_row\">
            <td>
                <input type=\"text\" class=\"true_name\" name=\"true_name\"/>
            </td>
            <td>
                <select class=\"species\" name=\"species\">
                    <option selected=\"selected\">Bovine</option>
                    <option>Equine</option>
                </select>
            </td>
            <td>
                <input type=\"text\" class=\"extra_display_info\" name=\"extra_display_info\"/>
            </td>
        </tr>

        <tr>
          <td colspan=\"3\" style=\"text-align: center\">
            <input type=\"submit\" value=\"Make the Change\"/>
          </td>
        </tr>
    </table>

</form>
"
  )



(def parsed-herd-html (html/html-resource (java.io.StringReader. herd-html)))


(html/select parsed-herd-html [:tr.per_animal_row])


(html/select parsed-herd-html [:td])


(html/select parsed-herd-html [:#extra-display-info])

(pprint/pprint (html/select parsed-herd-html [(html/attr= :class "extra_display_info")]))


(pprint/pprint (html/select parsed-herd-html [#{:select (html/attr= :selected "selected")}]))


; NOTE: https://github.com/cgrand/enlive/wiki/Table-and-Layout-Tutorial%2C-Part-3%3A-Simple-Transformations


(html/select parsed-herd-html [[:option (html/attr= :selected "selected")]])


(html/select  parsed-herd-html [#{:select (html/attr= :selected "selected")}])
