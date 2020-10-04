ids = ['cheese', 'butter', 'flour', 'burger', 'cheeseburger', 'fried_chicken', 'chicken_sandwich', 'pizza','tortilla', 'quesadilla','cooked_rice', 'fried_rice','grilled_cheese', 'toast','fries', 'fried_fish','fish_and_chips', 'shawarma','onion_rings']

with open("tomato.json", "r") as file:
    text = file.read()

for i in ids:
    file = open(f"{i}.json", "w+")
    file.write(text.replace("tomato", i))
    file.close()