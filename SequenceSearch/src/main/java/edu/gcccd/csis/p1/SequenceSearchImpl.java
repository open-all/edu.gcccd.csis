package edu.gcccd.csis.p1;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    /*
    find each tagged sequence and store them in a String array.
    return the array of tagged sequences

    @param fromIndex
    @param toIndex
    @param taggedStrings
     */
    @Override
    public String[] getAllTaggedSequences() {

        int fromIndex = 0;
        int toIndex = content.lastIndexOf(endTag); // start at the last tag
        String[] taggedStrings = {};

        do {
                if (0 <= (fromIndex = content.lastIndexOf(startTag, toIndex - endTag.length()))) {
                    // if the tags aren't in the correct format
                    if(content.substring(fromIndex + startTag.length(), toIndex).contains(endTag)) {
                        toIndex = content.indexOf(endTag, fromIndex + startTag.length());
                        taggedStrings = adds(taggedStrings, content.substring(fromIndex + startTag.length(), toIndex));
                    }else{
                        taggedStrings = adds(taggedStrings, content.substring(fromIndex + startTag.length(), toIndex));
                    }
                }
                toIndex = content.lastIndexOf(endTag, fromIndex - startTag.length());

        }while (-1 != toIndex);

        // reverse taggedStrings
        for ( int i = 0; i < taggedStrings.length/2; i++){
            String temp = taggedStrings[i];
            taggedStrings[i] = taggedStrings[taggedStrings.length-1-i];
            taggedStrings[taggedStrings.length-1-i] = temp;

        }

        return taggedStrings;
    }

    @Override
    public String getLongestTaggedSequence() {
        String [] taggedSequences = getAllTaggedSequences();
        int longestString =0;
        String longest = null;
        for (int i =0; i < taggedSequences.length; i++) {
            if (longestString <= taggedSequences[i].length())
                longest = taggedSequences[i];
                longestString = longest.length();
        }
        return longest;
    }

    @Override
    public String displayStringArray() {
        String[] taggedSequences = getAllTaggedSequences();
        String seperatedArray = "";
        for(int i =0; i < taggedSequences.length; i++){
             seperatedArray += taggedSequences[i] + " : " + taggedSequences[i].length() + "\n";
        }
        return seperatedArray;
    }

    @Override
    public String toString() {
        String noTags = "";
        if (startTag.equals(endTag)){
            noTags = content.replaceAll(startTag, "");
        }else {
            noTags = content.replaceAll(startTag, "");
            noTags = noTags.replaceAll(endTag, "");
        }
        return noTags;
    }

}