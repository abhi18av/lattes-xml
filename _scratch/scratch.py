from io import StringIO, BytesIO
from lxml import etree

# read DTD as string
#f = StringIO("<!ELEMENT b EMPTY>")
#dtd = etree.DTD(f)

# read DTD from file

f = open("./_scratch/scratch.DTD")
dtd = etree.DTD(f)

root = etree.XML("<b/>")
print(dtd.validate(root))

root = etree.XML("<b><a/></b>")
print(dtd.validate(root))
