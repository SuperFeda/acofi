# Alternate Create Of Fiery Items

<p align="center">
    <img src="https://cdn.discordapp.com/attachments/968157912843288606/1513983261091823656/acofi.png?ex=6a29b649&is=6a2864c9&hm=88c4a0fff64ebe2090e8edcbcd531ac991f85c36b6446ef0801a08c7fffecd9d&">
</p>

<details>
<summary>[EN] About the mod</summary>

## About the mod

Alternate Create Of Fiery Items (ACOFI) is an addon for [Twilight Forest](https://www.curseforge.com/minecraft/mc-mods/the-twilight-forest) that changes the way of obtaining fiery equipment, making it similar to netherite after the 1.20 update.


## Fiery upgrade template

The template is used to upgrade iron gear into fiery gear. It spawns in chests within the Ur-ghast's Dark Tower.

<p align="center">
  <img src="https://cdn.discordapp.com/attachments/968157912843288606/1513962716014969024/image.png?ex=6a29a327&is=6a2851a7&hm=2765a5d78c8d6f9db5581ea5044ab72874ba54d75fcb2c5d22657534c592ecc6&">
</p>


## Configuration

(*For mod versions 1.2.0 and above*)

Configuration file – `/config/acofi-common.toml`

In the config, you can adjust the spawn chance of the template and which loot tables it will generate in. That means you can make the template drop from a specific mob, boss, or in any other structure besides the Dark Tower.

Example config:

```toml
["ACOFI Config"]
  #Upgrade template spawn chance. (0.2 = 20%)
  #Default: 0.2
  #Range: 0.0 ~ 1.0
  upgrade_template_spawn_chance = 0.65
  #List of loot table IDs where the upgrade template will spawn.
  #Default: ["twilightforest:chests/darktower_cache", "twilightforest:chests/darktower_key"]
  target_tables = ["minecraft:chests/end_city_treasure", "minecraft:entities/warden"]
```

</details>


<details>
<summary>[RU] Про мод</summary>

## О моде

Alternate Create Of Fiery Items (ACOFI) - это аддон для [Twilight forest](https://www.curseforge.com/minecraft/mc-mods/the-twilight-forest) меняющий способ создания огненного снаряжения, на подобный незеритовому после обновления 1.20.


## Шаблон огненного улучшения

Шаблон используется для улучшения железных вещей в огненные. Спавнится в сундуках тёмной башни Ур-Гаста. 

<p align="center">
  <img src="https://cdn.discordapp.com/attachments/968157912843288606/1513962716014969024/image.png?ex=6a29a327&is=6a2851a7&hm=2765a5d78c8d6f9db5581ea5044ab72874ba54d75fcb2c5d22657534c592ecc6&">
</p>


## Конфигурация

(*Для версии мода начиная с 1.2.0 и выше*)

Файл конфигурации - `/config/acofi-common.toml`

В конфиге можно настроить шанс спавна шаблона и в каких таблицах лута он будет генерироваться. То есть, можно сделать чтобы шаблон дропался с какого-то моба, босса или в любой другой структуре помимо тёмной башни. 

Пример конфига:

```toml
["ACOFI Config"]
  #Upgrade template spawn chance. (0.2 = 20%)
  #Default: 0.2
  #Range: 0.0 ~ 1.0
  upgrade_template_spawn_chance = 0.65
  #List of loot table IDs where the upgrade template will spawn.
  #Default: ["twilightforest:chests/darktower_cache", "twilightforest:chests/darktower_key"]
  target_tables = ["minecraft:chests/end_city_treasure", "minecraft:entities/warden"]
```

</details>

