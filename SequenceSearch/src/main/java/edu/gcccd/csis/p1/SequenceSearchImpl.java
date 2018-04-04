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

        int fromIndex = -startTag.length();
        int toIndex = -endTag.length();
        String[] taggedStrings = {};

        while( -1 != (fromIndex = content.indexOf(startTag, fromIndex + startTag.length()))) {
            toIndex =  content.indexOf(endTag, fromIndex + startTag.length());
            if(toIndex == -1) {
                break;
            }
            if (content.substring(fromIndex + startTag.length(), toIndex).contains(startTag))
                fromIndex = content.lastIndexOf(startTag , toIndex);

            taggedStrings = adds(taggedStrings, content.substring(fromIndex + startTag.length(), toIndex));

        } if(startTag.equals(endTag) && (taggedStrings.length%2 ==0)) {
                String[] evenTags = new String[(taggedStrings.length / 2)];
                for (int i = 0; i <= evenTags.length; i++) {
                    evenTags[i] = taggedStrings[i * 2];

                }
            return evenTags;

        }else if(startTag.equals(endTag) && (taggedStrings.length%2 != 0)){
            String[] oddTags = new String[(taggedStrings.length/2)+1];
            for (int i = 0; i < oddTags.length; i++) {
                oddTags[i] = taggedStrings[i * 2];
            }
            return oddTags;
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