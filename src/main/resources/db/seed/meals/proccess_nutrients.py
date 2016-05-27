import sys
import csv
with open(sys.argv[1],"rb") as source:
    rdr= csv.reader( source, delimiter='^' )
    with open(sys.argv[2],"wb") as result:
        wtr= csv.writer( result, delimiter='^' )
        for r in rdr:
            if r[1] == "~208~" or r[1] == "~204~" or r[1] == "~203~":
                wtr.writerow( r )
