BINARIES=dist build
DOXYFILE=doc/Doxyfile

all:compile doc

compile:
	ant compile
doc:$(DOXYFILE)
	doxygen $<
test:
	ant testmath
testgui:
	ant testgui
clean:
	rm -r $(BINARIES)
pack:
	zip -r xcocul00_xkrajn02_xprext00_xseged00.zip ../xcocul00_xkrajn02_xprext00_xseged00

.PHONY: all compile clean doc test doc
