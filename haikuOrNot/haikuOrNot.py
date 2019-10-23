class Poem:

    number_of_poems = 0

    def __init__(self, author, title,):
        self.author = author
        self.title = title
        Poem.number_of_poems += 1

    def __str__(self):
        return "\"{}\" by {} this {}:\n\n{}\n".format(
            self.title,
            self.author,
            "is a haiku" if self.getType() else "is not a haiku",
            "\n".join(str(x) for x in self.getText()))

    def getText(self):
        return self.text

    def getType(self):
        return self.haikuPoem

    def setText(self, *text):
        self.text = list(text)

    def setType(self, haikuPoem):
        self.haikuPoem = haikuPoem

def main():
    AnaisNin = Poem("Anais Nin","Risk")
    AnaisNin.setText("And then the day came,", "when the risk", "to remain tight", "in a bud", "was more painful", "than the risk", "it took", "to blossom.")
    AnaisNin.setType(False)
    print(AnaisNin)

    MatsuoBasho = Poem("Matsuo Basho","The Old Pond")
    MatsuoBasho.setText("An old silent pond...", "A frog jumps into the pond,", "splash! Silence again.")
    MatsuoBasho.setType(True)
    print(MatsuoBasho)

    MurakamiKijo = Poem("Murakami Kijo","Climb Mount Fuji")
    MurakamiKijo.setText("First autumn morning", "the mirror I stare into", "shows my father's face.")
    MurakamiKijo.setType(True)
    print(MurakamiKijo)

if __name__ == '__main__':
    main()
