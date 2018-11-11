from io import StringIO, BytesIO
from lxml import etree
import xml.etree.ElementTree as ET
# read DTD as string
#f = StringIO("<!ELEMENT b EMPTY>")
#dtd = etree.DTD(f)

# read DTD from file

#dtd_file = open("./personal-sample-oxygen/personal.DTD")

dtd_string = StringIO("""
<?xml version="1.0" encoding="UTF-8"?>
<!--doc:Defines the personnel as a collection of person elements. -->
<!ELEMENT personnel (person)+>
<!ATTLIST personnel xmlns CDATA "http://www.oxygenxml.com/ns/samples/personal" >
<!--doc:Specify information about a person. -->
<!ELEMENT person (name, email*,link?, url*)>
<!ATTLIST person id ID #REQUIRED>
<!ATTLIST person photo CDATA #REQUIRED>
<!ATTLIST person note CDATA #IMPLIED>
<!ATTLIST person contr (true|false) 'false'>
<!ATTLIST person salary CDATA #IMPLIED>
<!--doc:Specify the person's family and given name.-->
<!ELEMENT name ((family,given)|(given,family))>
<!--doc:The person's last name.-->
<!ELEMENT family (#PCDATA)>
<!--doc:The person's first name.-->
<!ELEMENT given (#PCDATA)>
<!--doc:The person's photo.-->
<!ELEMENT photo EMPTY>
<!ATTLIST photo ref CDATA #REQUIRED>
<!--doc:Email address for this person.-->
<!ELEMENT email (#PCDATA)>
<!--doc:Enter an URL for this person.-->
<!ELEMENT url EMPTY>
<!ATTLIST url href CDATA 'http://'>
<!--doc:Specify who is the manager and who are the subordinates for this person. -->
<!ELEMENT link EMPTY>
<!ATTLIST link manager IDREF #IMPLIED>
<!ATTLIST link subordinates IDREFS #IMPLIED>
<!NOTATION gif PUBLIC '-//APP/Photoshop/4.0' 'photoshop.exe'>
""")

dtd = etree.DTD(dtd_string)

#xml_file = open("./personal-sample-oxygen/personal.xml")

root = etree.XML(
"""
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE personnel PUBLIC "PERSONNEL" "personal.dtd">
<?xml-stylesheet type="text/css" href="personal.css"?>
<personnel>
    <person id="harris.anderson" photo="personal-images/harris.anderson.jpg">                
        <name>
            <given>Harris</given>
            <family>Anderson</family>
        </name>
        <email>harris.anderson@example.com</email>
        <link subordinates="robert.taylor helen.jackson michelle.taylor jason.chen harris.anderson brian.carter"/>
        <url href="http://www.example.com/na/harris-anderson.html"/>
    </person>
    <person id="robert.taylor" photo="personal-images/robert.taylor.jpg">
        <name>
            <given>Robert</given>
            <family>Taylor</family>
        </name>
        <email>robert.taylor@example.com</email>
        <link manager="harris.anderson"/>
        <url href="http://www.example.com/na/robert-taylor.html"/>
    </person>
    <person id="helen.jackson" photo="personal-images/helen.jackson.jpg">
        <name>
            <given>Helen</given>
            <family>Jackson</family>
        </name>        
        <email>hellen.jackson@example.com</email>
        <link manager="harris.anderson"/>
        <url href="http://www.example.com/na/hellen-jackson.html"/>
    </person>
    <person id="michelle.taylor" photo="personal-images/michelle.taylor.jpg">
        <name>
            <given>Michelle</given>
            <family>Taylor</family>
        </name>
        <email>michelle.taylor@example.com</email>
        <link manager="harris.anderson"/>
        <url href="http://www.example.com/na/michelle-taylor.html"/>
    </person>
    <person id="jason.chen" photo="personal-images/jason.chen.jpg">
        <name>
            <given>Jason</given>
            <family>Chen</family>
        </name>
        <email>jason.chen@example.com</email>
        <link manager="harris.anderson"/>
        <url href="http://www.example.com/na/jason-chen.html"/>        
    </person>
    <person id="brian.carter" photo="personal-images/brian.carter.jpg" >
        <name>
            <given>Brian</given>
            <family>Carter</family>
        </name>
        <email>brian.carter@example.com</email>
        <link manager="harris.anderson"/>
        <url href="http://www.example.com/na/brian-carter.html"/>
    </person>
</personnel>



"""
)
#tree = ET.parse("./personal-sample-oxygen/personal.xml")
#root = tree.getroot()
print(dtd.validate(root))