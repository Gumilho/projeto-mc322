import json

with open("demacia.json") as f:
    demacia = json.load(f)
demacia = list(filter(lambda card: card["set"] == "1", demacia))
print(len(demacia))
demacia.sort(key=lambda x: x["cost"])
for card in demacia:
    print(card["title"])