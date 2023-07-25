/*      */ package me.VideoSRC.menus;

/*      */
/*      */ import java.util.ArrayList;

/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.ChatColor;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.EventHandler;
/*      */ import org.bukkit.event.Listener;
/*      */ import org.bukkit.event.inventory.InventoryClickEvent;
/*      */ import org.bukkit.inventory.Inventory;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.meta.ItemMeta;

import me.VideoSRC.api.Strings;

/*      */
/*      */ public class MenuKits1 implements Listener
/*      */ {
	/* 20 */ public static ArrayList<String> ListaKits2 = new ArrayList();

	/*      */
	/*      */
	/*      */ public static void InventarioKitsGui(Player p)
	/*      */ {
		/* 25 */ Inventory inv = Bukkit.getServer().createInventory(p, 54, "§8Seus Kits! §a1");

		/* 26 */ ItemStack vidro = new ItemStack(Material.getMaterial(102));
		/* 27 */ ItemMeta metav = vidro.getItemMeta();
		/* 28 */ metav.setDisplayName(" ");
		/* 29 */ vidro.setItemMeta(metav);
		/*      */
		/* 31 */ inv.setItem(0, vidro);
		/* 32 */ inv.setItem(1, vidro);
		/* 33 */ inv.setItem(2, vidro);
		/* 34 */ inv.setItem(3, vidro);
		/* 35 */ inv.setItem(4, vidro);
		/* 36 */ inv.setItem(5, vidro);
		/* 37 */ inv.setItem(6, vidro);
		/* 38 */ inv.setItem(7, vidro);
		/* 39 */ inv.setItem(8, vidro);

		/* 53 */ ItemStack Carpets = new ItemStack(Material.getMaterial(289));
		/* 55 */ ItemMeta metacarpets = Carpets.getItemMeta();
		/* 56 */ metacarpets.setDisplayName(Strings.nomeserver);
		/* 57 */ Carpets.setItemMeta(metacarpets);
		/* 58 */ inv.setItem(4, Carpets);
		/*     */
		/* 77 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 79 */ ItemStack pyro = new ItemStack(Material.CAKE);
			/* 80 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 81 */ metapyro.setDisplayName("§aSurprise");
			/* 82 */ ArrayList<String> descpyro = new ArrayList();
			/* 83 */
			/* 84 */ descpyro.add(ChatColor.GRAY + "§7Venha com um kit random");
			/* 85 */ descpyro.add(ChatColor.GRAY + "§7Ao iniciar a partida!");
			/* 86 */ metapyro.setLore(descpyro);
			/* 87 */ pyro.setItemMeta(metapyro);
			/* 88 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 482 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 484 */ ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			/* 485 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 486 */ metapyro.setDisplayName("§aFisherman");
			/* 487 */ ArrayList<String> descpyro = new ArrayList();
			/* 488 */
			/* 489 */ descpyro.add(ChatColor.GRAY + "§7Com sua vara de pesca puxe jogadores");
			/* 490 */ descpyro.add(ChatColor.GRAY + "§7Para sua posição!");
			/* 491 */ metapyro.setLore(descpyro);
			/* 492 */ pyro.setItemMeta(metapyro);
			/* 493 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 521 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 523 */ ItemStack pyro = new ItemStack(Material.SNOW_BALL);
			/* 524 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 525 */ metapyro.setDisplayName("§aSwitcher");
			/* 526 */ ArrayList<String> descpyro = new ArrayList();
			/* 527 */
			/* 528 */ descpyro.add(ChatColor.GRAY + "§7Troque de posição com seus inimigos");
			/* 529 */ descpyro.add(ChatColor.GRAY + "§7Podendo fazer estrategias");
			/* 530 */ metapyro.setLore(descpyro);
			/* 531 */ pyro.setItemMeta(metapyro);
			/* 532 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 534 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.tank"))
		/*      */ {
			/* 536 */ ItemStack pyro = new ItemStack(Material.TNT);
			/* 537 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 538 */ metapyro.setDisplayName("§aTank");
			/* 539 */ ArrayList<String> descpyro = new ArrayList();
			/* 540 */
			/* 541 */ descpyro.add(ChatColor.GRAY + "§7Ao matar um jogador crie uma explosao");
			/* 542 */ descpyro.add(ChatColor.GRAY + "§7Atenção: Voce não leva dano por explosoes");
			/* 543 */ metapyro.setLore(descpyro);
			/* 544 */ pyro.setItemMeta(metapyro);
			/* 545 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 547 */ if (p.hasPermission("tag.membro")  || p.hasPermission("hg.kit.thor"))
		/*      */ {
			/* 549 */ ItemStack pyro = new ItemStack(Material.STONE_AXE);
			/* 550 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 551 */ metapyro.setDisplayName("§aThor");
			/* 552 */ ArrayList<String> descpyro = new ArrayList();
			/* 553 */
			/* 554 */ descpyro.add(ChatColor.GRAY + "§7Solte raios com");
			/* 555 */ descpyro.add(ChatColor.GRAY + "§7Seu machado!");
			/* 556 */ metapyro.setLore(descpyro);
			/* 557 */ pyro.setItemMeta(metapyro);
			/* 558 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 560 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.timelord"))
		/*      */ {
			/* 562 */ ItemStack pyro = new ItemStack(Material.WATCH);
			/* 563 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 564 */ metapyro.setDisplayName("§aTimelord");
			/* 565 */ ArrayList<String> descpyro = new ArrayList();
			/* 566 */
			/* 567 */ descpyro.add(ChatColor.GRAY + "§7Congele seus oponentes");
			/* 568 */ descpyro.add(ChatColor.GRAY + "§7No ar podendo mata-lo rapidamente");
			/* 569 */ metapyro.setLore(descpyro);
			/* 570 */ pyro.setItemMeta(metapyro);
			/* 571 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 573 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 575 */ ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
			/* 576 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 577 */ metapyro.setDisplayName("§aTurtle");
			/* 578 */ ArrayList<String> descpyro = new ArrayList();
			/* 579 */
			/* 580 */ descpyro.add(ChatColor.GRAY + "§7Ao Segurar shift");
			/* 581 */ descpyro.add(ChatColor.GRAY + "§7Tenha seu dano reduzido");
			/* 582 */ metapyro.setLore(descpyro);
			/* 583 */ pyro.setItemMeta(metapyro);
			/* 584 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 586 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 588 */ ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			/* 589 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 590 */ metapyro.setDisplayName("§aViper");
			/* 591 */ ArrayList<String> descpyro = new ArrayList();
			/* 592 */
			/* 593 */ descpyro.add(ChatColor.GRAY + "§7Ao hitar um jogador tenha 33% de");
			/* 594 */ descpyro.add(ChatColor.GRAY + "§7Dar efeito de Poison no oponente");
			/* 595 */ metapyro.setLore(descpyro);
			/* 596 */ pyro.setItemMeta(metapyro);
			/* 597 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 599 */ if (p.hasPermission("role.vip"))
		/*      */ {
			/* 601 */ ItemStack pyro = new ItemStack(Material.DIRT);
			/* 602 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 603 */ metapyro.setDisplayName("§aWorm");
			/* 604 */ ArrayList<String> descpyro = new ArrayList();
			/* 606 */ descpyro.add(ChatColor.GRAY + "§7Pegue terra instantaneamente");
			/* 607 */ descpyro.add(ChatColor.GRAY + "§7Tenha seu dano reduzido");
			/* 608 */ metapyro.setLore(descpyro);
			/* 609 */ pyro.setItemMeta(metapyro);
			/* 610 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 71 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.sponge")) {
			/* 72 */ ItemStack pyro = new ItemStack(Material.SPONGE);
			/* 73 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 74 */ metapyro.setDisplayName("§aLauncher");
			/* 75 */ ArrayList<String> descpyro = new ArrayList();
			/* 76 */ descpyro.add(ChatColor.GRAY + "§7Fa§7 plataformas");
			/* 77 */ descpyro.add(ChatColor.GRAY + "§7Para se mover rapidamente!");
			/* 78 */ metapyro.setLore(descpyro);
			/* 79 */ pyro.setItemMeta(metapyro);
			/* 80 */ inv.addItem(new ItemStack[] { pyro });
			/*     */ }

		/* 495 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.specialist"))
		/*      */ {
			/* 497 */ ItemStack pyro = new ItemStack(Material.ENCHANTED_BOOK);
			/* 498 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 499 */ metapyro.setDisplayName("§aSpecialist");
			/* 500 */ ArrayList<String> descpyro = new ArrayList();
			/* 501 */
			/* 502 */ descpyro.add(ChatColor.GRAY + "§7Tenha uma Enchant portatil");
			/* 503 */ descpyro.add(ChatColor.GRAY + "§7Ao matar algum jogador receba 1 de xp");
			/* 504 */ metapyro.setLore(descpyro);
			/* 505 */ pyro.setItemMeta(metapyro);
			/* 506 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 508 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 510 */ ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
			/* 511 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 512 */ metapyro.setDisplayName("§aStomper");
			/* 513 */ ArrayList<String> descpyro = new ArrayList();
			/* 514 */
			/* 515 */ descpyro.add(ChatColor.GRAY + "§7Esmague seus oponente");
			/* 516 */ descpyro.add(ChatColor.GRAY + "§7Bom para torres");
			/* 517 */ metapyro.setLore(descpyro);
			/* 518 */ pyro.setItemMeta(metapyro);
			/* 519 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 90 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.madman"))
		/*      */ {
			/* 92 */ ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
			/* 93 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 94 */ metapyro.setDisplayName("§aMadman");
			/* 95 */ ArrayList<String> descpyro = new ArrayList();
			/* 96 */ descpyro.add(ChatColor.GRAY + "§7Deixe seus oponentes");
			/* 97 */ descpyro.add(ChatColor.GRAY + "§7Com efeito De fraqueza!");
			/* 98 */ metapyro.setLore(descpyro);
			/* 99 */ pyro.setItemMeta(metapyro);
			/* 100 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 443 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.poseidon"))
		/*      */ {
			/* 445 */ ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
			/* 446 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 447 */ metapyro.setDisplayName("§aPoseidon");
			/* 448 */ ArrayList<String> descpyro = new ArrayList();
			/* 449 */
			/* 450 */ descpyro.add(ChatColor.GRAY + "§7Ao ficar na agua receba");
			/* 451 */ descpyro.add(ChatColor.GRAY + "§7Forca e velocidade!");
			/* 452 */ metapyro.setLore(descpyro);
			/* 453 */ pyro.setItemMeta(metapyro);
			/* 454 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 114 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 116 */ ItemStack pyro = new ItemStack(Material.STICK);
			/* 117 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 118 */ metapyro.setDisplayName("§aGrandpa");
			/* 119 */ ArrayList<String> descpyro = new ArrayList();
			/* 120 */ descpyro.add(ChatColor.GRAY + "§7Nasca com um stick");
			/* 121 */ descpyro.add(ChatColor.GRAY + "§7Knockback 2!");
			/* 122 */ metapyro.setLore(descpyro);
			/* 123 */ pyro.setItemMeta(metapyro);
			/* 124 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 456 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.reaper"))
		/*      */ {
			/* 458 */ ItemStack pyro = new ItemStack(Material.WOOD_HOE);
			/* 459 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 460 */ metapyro.setDisplayName("§aReaper");
			/* 461 */ ArrayList<String> descpyro = new ArrayList();
			/* 462 */
			/* 463 */ descpyro.add(ChatColor.GRAY + "§7Ao Hitar um jogador de");
			/* 464 */ descpyro.add(ChatColor.GRAY + "§7Efeito de Wither nele");
			/* 465 */ metapyro.setLore(descpyro);
			/* 466 */ pyro.setItemMeta(metapyro);
			/* 467 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 138 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.crafter"))
		/*      */ {
			/* 140 */ ItemStack pyro = new ItemStack(Material.WORKBENCH);
			/* 141 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 142 */ metapyro.setDisplayName("§aCrafter");
			/* 143 */ ArrayList<String> descpyro = new ArrayList();
			/* 144 */ descpyro.add(ChatColor.GRAY + "§7Tenha uma WorkBench");
			/* 145 */ descpyro.add(ChatColor.GRAY + "§7Portatil");
			/* 146 */ metapyro.setLore(descpyro);
			/* 147 */ pyro.setItemMeta(metapyro);
			/* 148 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 469 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.snail"))
		/*      */ {
			/* 471 */ ItemStack pyro = new ItemStack(Material.WEB);
			/* 472 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 473 */ metapyro.setDisplayName("§aSnail");
			/* 474 */ ArrayList<String> descpyro = new ArrayList();
			/* 475 */
			/* 476 */ descpyro.add(ChatColor.GRAY + "§7Ao hitar um jogador tenha 33% de");
			/* 477 */ descpyro.add(ChatColor.GRAY + "§7Dar efeito de lentidao II no oponente");
			/* 478 */ metapyro.setLore(descpyro);
			/* 479 */ pyro.setItemMeta(metapyro);
			/* 480 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }

		/* 53 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 55 */ ItemStack pyro = new ItemStack(Material.FIREWORK);
			/* 56 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 57 */ metapyro.setDisplayName("§aKangaroo");
			/* 58 */ ArrayList<String> descpyro = new ArrayList();
			/* 59 */ descpyro.add(ChatColor.GRAY + "§7§7Com seu Firework");
			/* 60 */ descpyro.add(ChatColor.GRAY + "§7Se mova rapidamente!");
			/* 61 */ metapyro.setLore(descpyro);
			/* 62 */ pyro.setItemMeta(metapyro);
			/* 63 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 213 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.enderman"))
		/*      */ {
			/* 215 */ ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
			/* 216 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 217 */ metapyro.setDisplayName("§aEnderman");
			/* 218 */ ArrayList<String> descpyro = new ArrayList();
			/* 219 */ descpyro.add(ChatColor.GRAY + "§7Nasca com 3 perolas do ender");
			/* 220 */ descpyro.add(ChatColor.GRAY + "§7Ao matar um jogador ganhe + 1!");
			/* 221 */ metapyro.setLore(descpyro);
			/* 222 */ pyro.setItemMeta(metapyro);
			/* 223 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 225 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.anchor"))
		/*      */ {
			/* 227 */ ItemStack pyro = new ItemStack(Material.ANVIL);
			/* 228 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 229 */ metapyro.setDisplayName("§aAnchor");
			/* 230 */ ArrayList<String> descpyro = new ArrayList();
			/* 231 */ descpyro.add(ChatColor.GRAY + "§7Tenha seu pvp");
			/* 232 */ descpyro.add(ChatColor.GRAY + "§7Em velocidade 0!");
			/* 233 */ metapyro.setLore(descpyro);
			/* 234 */ pyro.setItemMeta(metapyro);
			/* 235 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 237 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.cultivator"))
		/*      */ {
			/* 239 */ ItemStack pyro = new ItemStack(Material.getMaterial(6));
			/* 240 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 241 */ metapyro.setDisplayName("§aCultivator");
			/* 242 */ ArrayList<String> descpyro = new ArrayList();
			/* 243 */ descpyro.add(ChatColor.GRAY + "§7Plante arvores e trigo");
			/* 244 */ descpyro.add(ChatColor.GRAY + "§7Instantaneamente!");
			/* 245 */ metapyro.setLore(descpyro);
			/* 246 */ pyro.setItemMeta(metapyro);
			/* 247 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 249 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 251 */ ItemStack pyro = new ItemStack(Material.SADDLE);
			/* 252 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 253 */ metapyro.setDisplayName("§aHulk");
			/* 254 */ ArrayList<String> descpyro = new ArrayList();
			/* 255 */ descpyro.add(ChatColor.GRAY + "§7Pegue jogadores no colo");
			/* 256 */ descpyro.add(ChatColor.GRAY + "§7Matando com facilidade");
			/* 257 */ metapyro.setLore(descpyro);
			/* 258 */ pyro.setItemMeta(metapyro);
			/* 259 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		 if (p.hasPermission("tag.membro"))
			/*      */ {
				/* 251 */ ItemStack pyro = new ItemStack(Material.RAW_CHICKEN);
				/* 252 */ ItemMeta metapyro = pyro.getItemMeta();
				/* 253 */ metapyro.setDisplayName("§aCannibal");
				/* 254 */ ArrayList<String> descpyro = new ArrayList();
				/* 255 */ descpyro.add(ChatColor.GRAY + "§7De fome nos inimigos");
				/* 256 */ descpyro.add(ChatColor.GRAY + "§7Ao hita-los");
				/* 257 */ metapyro.setLore(descpyro);
				/* 258 */ pyro.setItemMeta(metapyro);
				/* 259 */ inv.addItem(new ItemStack[] { pyro });
				/*      */ }
		/* 261 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.fireman"))
		/*      */ {
			/* 263 */ ItemStack pyro = new ItemStack(Material.LAVA_BUCKET);
			/* 264 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 265 */ metapyro.setDisplayName("§aFireman");
			/* 266 */ ArrayList<String> descpyro = new ArrayList();
			/* 267 */ descpyro.add(ChatColor.GRAY + "§7Nao receba dano de fogo");
			/* 268 */ descpyro.add(ChatColor.GRAY + "§7Espadas de madeira dao chamas em oponentes");
			/* 269 */ metapyro.setLore(descpyro);
			/* 270 */ pyro.setItemMeta(metapyro);
			/* 271 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 273 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.tower"))
		/*      */ {
			/* 275 */ ItemStack pyro = new ItemStack(Material.DIAMOND_BOOTS);
			/* 276 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 277 */ metapyro.setDisplayName("§aTower");
			/* 278 */ ArrayList<String> descpyro = new ArrayList();
			/* 279 */ descpyro.add(ChatColor.GRAY + "§7Kit perfeito para torres!");
			/* 280 */ descpyro.add(ChatColor.GRAY + "§7Seja Stomper/Worm em 1 so kit!");
			/* 281 */ metapyro.setLore(descpyro);
			/* 282 */ pyro.setItemMeta(metapyro);
			/* 283 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 285 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.viking"))
		/*      */ {
			/* 287 */ ItemStack pyro = new ItemStack(Material.IRON_AXE);
			/* 288 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 289 */ metapyro.setDisplayName("§aViking");
			/* 290 */ ArrayList<String> descpyro = new ArrayList();
			/* 291 */ descpyro.add(ChatColor.GRAY + "§7Tenha um dano");
			/* 292 */ descpyro.add(ChatColor.GRAY + "§7Mais fortes que espadas!");
			/* 293 */ metapyro.setLore(descpyro);
			/* 294 */ pyro.setItemMeta(metapyro);
			/* 295 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 297 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.demoman"))
		/*      */ {
			/* 299 */ ItemStack pyro = new ItemStack(Material.getMaterial(70));
			/* 300 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 301 */ metapyro.setDisplayName("§aDemoman");
			/* 302 */ ArrayList<String> descpyro = new ArrayList();
			/* 303 */ descpyro.add(ChatColor.GRAY + "§7Ao colocar uma gravel e a stone plate");
			/* 304 */ descpyro.add(ChatColor.GRAY + "§7Quem pisar sera morto por uma explosao!");
			/* 305 */ metapyro.setLore(descpyro);
			/* 306 */ pyro.setItemMeta(metapyro);
			/* 307 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 321 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.endermage"))
		/*      */ {
			/* 323 */ ItemStack pyro = new ItemStack(Material.PORTAL);
			/* 324 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 325 */ metapyro.setDisplayName("§aEndermage");
			/* 326 */ ArrayList<String> descpyro = new ArrayList();
			/* 327 */ descpyro.add(ChatColor.GRAY + "§7Com seu portal puxe jogadores");
			/* 328 */ descpyro.add(ChatColor.GRAY + "§7A sua posição!");
			/* 329 */ metapyro.setLore(descpyro);
			/* 330 */ pyro.setItemMeta(metapyro);
			/* 331 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 345 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 347 */ ItemStack pyro = new ItemStack(Material.COAL);
			/* 348 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 349 */ metapyro.setDisplayName("§aForger");
			/* 350 */ ArrayList<String> descpyro = new ArrayList();
			/* 351 */ descpyro.add(ChatColor.GRAY + "§7Seja uma fornalha automatica");
			/* 352 */ descpyro.add(ChatColor.GRAY + "§7Faça minerios rapidamente");
			/* 353 */ metapyro.setLore(descpyro);
			/* 354 */ pyro.setItemMeta(metapyro);
			/* 355 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 357 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.gladiator"))
		/*      */ {
			/* 359 */ ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			/* 360 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 361 */ metapyro.setDisplayName("§aGladiator");
			/* 362 */ ArrayList<String> descpyro = new ArrayList();
			/* 363 */ descpyro.add(ChatColor.GRAY + "§7Crie uma arena 1v1");
			/* 364 */ descpyro.add(ChatColor.GRAY + "§7Contra algum jogador!");
			/* 365 */ metapyro.setLore(descpyro);
			/* 366 */ pyro.setItemMeta(metapyro);
			/* 367 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 369 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.grappler"))
		/*      */ {
			/* 371 */ ItemStack pyro = new ItemStack(Material.LEASH);
			/* 372 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 373 */ metapyro.setDisplayName("§aGrappler");
			/* 374 */ ArrayList<String> descpyro = new ArrayList();
			/* 375 */ descpyro.add(ChatColor.GRAY + "§7Com sua corda se mova");
			/* 376 */ descpyro.add(ChatColor.GRAY + "§7Rapidamente");
			/* 377 */ metapyro.setLore(descpyro);
			/* 378 */ pyro.setItemMeta(metapyro);
			/* 379 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 381 */ /* 126 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.copycat"))
		/*      */ {
			/* 128 */ ItemStack pyro = new ItemStack(Material.YELLOW_FLOWER);
			/* 129 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 130 */ metapyro.setDisplayName("§aCopyCat");
			/* 131 */ ArrayList<String> descpyro = new ArrayList();
			/* 132 */ descpyro.add(ChatColor.GRAY + "§7Ao Matar um jogador");
			/* 133 */ descpyro.add(ChatColor.GRAY + "§7Receba o kit dele!");
			/* 134 */ metapyro.setLore(descpyro);
			/* 135 */ pyro.setItemMeta(metapyro);
			/* 136 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 381 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.jellyfish"))
		/*      */ {
			/* 383 */ ItemStack pyro = new ItemStack(Material.CLAY_BALL);
			/* 384 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 385 */ metapyro.setDisplayName("§aJellyfish");
			/* 386 */ ArrayList<String> descpyro = new ArrayList();
			/* 387 */ descpyro.add(ChatColor.GRAY + "§7Coloque agua com sua mão");
			/* 388 */ descpyro.add(ChatColor.GRAY + "§7Jogadores que cair nela receberão poison");
			/* 389 */ metapyro.setLore(descpyro);
			/* 390 */ pyro.setItemMeta(metapyro);
			/* 391 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 393 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 395 */ ItemStack pyro = new ItemStack(Material.WOOD_AXE);
			/* 396 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 397 */ metapyro.setDisplayName("§aLumberjack");
			/* 398 */ ArrayList<String> descpyro = new ArrayList();
			/* 399 */ descpyro.add(ChatColor.GRAY + "§7Quebre arvores");
			/* 400 */ descpyro.add(ChatColor.GRAY + "§7Instantaneamente");
			/* 401 */ metapyro.setLore(descpyro);
			/* 402 */ pyro.setItemMeta(metapyro);
			/* 403 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 405 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 407 */ ItemStack pyro = new ItemStack(Material.STONE_PICKAXE);
			/* 408 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 409 */ metapyro.setDisplayName("§aMiner");
			/* 410 */ ArrayList<String> descpyro = new ArrayList();
			/* 411 */ descpyro.add(ChatColor.GRAY + "§7Ao quebrar qualquer minerio");
			/* 412 */ descpyro.add(ChatColor.GRAY + "§7Instantaneamente");
			/* 413 */ metapyro.setLore(descpyro);
			/* 414 */ pyro.setItemMeta(metapyro);
			/* 415 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 417 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 419 */ ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			/* 420 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 421 */ metapyro.setDisplayName("§aMonk");
			/* 422 */ ArrayList<String> descpyro = new ArrayList();
			/* 423 */
			/* 424 */ descpyro.add(ChatColor.GRAY + "§7Desarme seus oponentes");
			/* 425 */ descpyro.add(ChatColor.GRAY + "§7Com o item do seu kit!");
			/* 426 */ metapyro.setLore(descpyro);
			/* 427 */ pyro.setItemMeta(metapyro);
			/* 428 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 430 */ if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.ninja"))
		/*      */ {
			/* 432 */ ItemStack pyro = new ItemStack(Material.EMERALD);
			/* 433 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 434 */ metapyro.setDisplayName("§aNinja");
			/* 435 */ ArrayList<String> descpyro = new ArrayList();
			/* 436 */
			/* 437 */ descpyro.add(ChatColor.GRAY + "§7Ao Hitar um jogador");
			/* 438 */ descpyro.add(ChatColor.GRAY + "§7Teleporte-se a posicao dele");
			/* 439 */ metapyro.setLore(descpyro);
			/* 440 */ pyro.setItemMeta(metapyro);
			/* 441 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		if (p.hasPermission("role.vip")  || p.hasPermission("hg.kit.flash"))
		/*      */ {
			/* 432 */ ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
			/* 433 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 434 */ metapyro.setDisplayName("§aFlash");
			/* 435 */ ArrayList<String> descpyro = new ArrayList();
			/* 436 */
			/* 437 */ descpyro.add(ChatColor.GRAY + "§7Se teleporte com um");
			/* 438 */ descpyro.add(ChatColor.GRAY + "§7Trovão");
			/* 439 */ metapyro.setLore(descpyro);
			/* 440 */ pyro.setItemMeta(metapyro);
			/* 441 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }

		/*      */ ItemStack[] arrayOfItemStack;
		/* 613 */ int descpyro = (arrayOfItemStack = inv.getContents()).length;
		/* 614 */ for (int metapyro = 0; metapyro < descpyro; metapyro++)
		/*      */ {
			/* 616 */ ItemStack item = arrayOfItemStack[metapyro];
			/* 617 */ if (item == null) {
				/*      */ }
			/*      */ }
		/* 621 */ p.openInventory(inv);
		/* 622 */ ListaKits2.add(p.getName());
		/*      */ }

	/*      */
	/*      */ @EventHandler
	/*      */ public void onPlayerCLickInventry(InventoryClickEvent e)
	/*      */ {
		/* 639 */ Player p = (Player) e.getWhoClicked();
		/* 640 */ if ((e.getInventory().getTitle().equalsIgnoreCase("§8Seus Kits! §a1")) && (e.getCurrentItem() != null)
				&& (e.getCurrentItem().getTypeId() != 0))
		/*      */ {
			/* 642 */ e.setCancelled(true);
			/* 643 */ if (e.getCurrentItem().getType() == Material.getMaterial(351))
			/*      */ {
				/*      */ }
			/* 643 */ if (e.getCurrentItem().getType() == Material.getMaterial(289))
			/*      */ {
				/* 645 */ e.setCancelled(true);
				/* 647 */ return;
				/*      */ }
			/* 649 */ if (e.getCurrentItem().getType() == Material.FIRE)
			/*      */ {
				/* 651 */ e.setCancelled(true);
				/* 652 */ p.closeInventory();
				/* 653 */ p.chat("/kit firer");
				/* 654 */ return;
				/*      */ }
			/* 663 */ if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP)
			/*      */ {
				/* 665 */ e.setCancelled(true);
				/* 666 */ p.closeInventory();
				/* 667 */ p.chat("/kit hermit");
				/* 668 */ return;
				/*      */ }
			/* 670 */ if (e.getCurrentItem().getType() == Material.CAKE)
			/*      */ {
				/* 672 */ e.setCancelled(true);
				/* 673 */ p.closeInventory();
				/* 674 */ p.chat("/kit surprise");
				/* 675 */ return;
				/*      */ }
			/* 684 */ if (e.getCurrentItem().getType() == Material.WORKBENCH)
			/*      */ {
				/* 686 */ e.setCancelled(true);
				/* 687 */ p.closeInventory();
				/* 688 */ p.chat("/kit crafter");
				/* 689 */ return;
				/*      */ }
			/* 691 */ if (e.getCurrentItem().getType() == Material.getMaterial(6))
			/*      */ {
				/* 693 */ e.setCancelled(true);
				/* 694 */ p.closeInventory();
				/* 695 */ p.chat("/kit cultivator");
				/* 696 */ return;
				/*      */ }
			/* 698 */ if (e.getCurrentItem().getType() == Material.LEATHER)
			/*      */ {
				/* 700 */ e.setCancelled(true);
				/* 701 */ p.closeInventory();
				/* 702 */ p.chat("/kit backpacker");
				/* 703 */ return;
				/*      */ }
			/* 705 */ if (e.getCurrentItem().getType() == Material.getMaterial(70))
			/*      */ {
				/* 707 */ e.setCancelled(true);
				/* 708 */ p.closeInventory();
				/* 709 */ p.chat("/kit demoman");
				/* 710 */ return;
				/*      */ }
			/* 719 */ if (e.getCurrentItem().getType() == Material.PORTAL)
			/*      */ {
				/* 721 */ e.setCancelled(true);
				/* 722 */ p.closeInventory();
				/* 723 */ p.chat("/kit endermage");
				/* 724 */ return;
				/*      */ }
			/* 726 */ if (e.getCurrentItem().getType() == Material.FISHING_ROD)
			/*      */ {
				/* 728 */ e.setCancelled(true);
				/* 729 */ p.closeInventory();
				/* 730 */ p.chat("/kit fisherman");
				/* 731 */ return;
				/*      */ }
			/* 733 */ if (e.getCurrentItem().getType() == Material.STICK)
			/*      */ {
				/* 735 */ e.setCancelled(true);
				/* 736 */ p.closeInventory();
				/* 737 */ p.chat("/kit grandpa");
				/* 738 */ return;
				/*      */ }
			/* 740 */ if (e.getCurrentItem().getType() == Material.ANVIL)
			/*      */ {
				/* 742 */ e.setCancelled(true);
				/* 743 */ p.closeInventory();
				/* 744 */ p.chat("/kit anchor");
				/* 745 */ return;
				/*      */ }
			/* 747 */ if (e.getCurrentItem().getType() == Material.COAL)
			/*      */ {
				/* 749 */ e.setCancelled(true);
				/* 750 */ p.closeInventory();
				/* 751 */ p.chat("/kit forger");
				/* 752 */ return;
				/*      */ }
			/* 754 */ if (e.getCurrentItem().getType() == Material.IRON_FENCE)
			/*      */ {
				/* 756 */ e.setCancelled(true);
				/* 757 */ p.closeInventory();
				/* 758 */ p.chat("/kit gladiator");
				/* 759 */ return;
				/*      */ }
			/* 761 */ if (e.getCurrentItem().getType() == Material.ENDER_PEARL)
			/*      */ {
				/* 763 */ e.setCancelled(true);
				/* 764 */ p.closeInventory();
				/* 765 */ p.chat("/kit enderman");
				/* 766 */ return;
				/*      */ }
			/* 768 */ if (e.getCurrentItem().getType() == Material.SAND)
			/*      */ {
				/* 770 */ e.setCancelled(true);
				/* 771 */ p.closeInventory();
				/* 772 */ p.chat("/kit desert");
				/* 773 */ return;
				/*      */ }
			/* 775 */ if (e.getCurrentItem().getType() == Material.IRON_INGOT)
			/*      */ {
				/* 777 */ e.setCancelled(true);
				/* 778 */ p.closeInventory();
				/* 779 */ p.chat("/kit durability");
				/* 780 */ return;
				/*      */ }
			/* 782 */ if (e.getCurrentItem().getType() == Material.LEASH)
			/*      */ {
				/* 784 */ e.setCancelled(true);
				/* 785 */ p.closeInventory();
				/* 786 */p.chat("/kit grappler");
				/* 787 */ return;
				/*      */ }
			/* 789 */ if (e.getCurrentItem().getType() == Material.SADDLE)
			/*      */ {
				/* 791 */ e.setCancelled(true);
				/* 792 */ p.closeInventory();
				/* 793 */ p.chat("/kit hulk");
				/* 794 */ return;
				/*      */ }
			/* 796 */ if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS)
			/*      */ {
				/* 798 */ e.setCancelled(true);
				/* 799 */ p.closeInventory();
				/* 800 */ p.chat("/kit tower");
				/* 801 */ return;
				/*      */ }
			/* 803 */ if (e.getCurrentItem().getType() == Material.CLAY_BALL)
			/*      */ {
				/* 805 */ e.setCancelled(true);
				/* 806 */ p.closeInventory();
				/* 807 */ p.chat("/kit jellyfish");
				/* 808 */ return;
				/*      */ }
			/* 810 */ if (e.getCurrentItem().getType() == Material.FIREWORK)
			/*      */ {
				/* 812 */ e.setCancelled(true);
				/* 813 */ p.closeInventory();
				/* 814 */ p.chat("/kit kangaroo");
				/* 815 */ return;
				/*      */ }
			/* 817 */ if (e.getCurrentItem().getType() == Material.YELLOW_FLOWER)
			/*      */ {
				/* 819 */ e.setCancelled(true);
				/* 820 */ p.closeInventory();
				/* 821 */ p.chat("/kit copycat");
				/* 822 */ return;
				/*      */ }
			/* 824 */ if (e.getCurrentItem().getType() == Material.WOOD_AXE)
			/*      */ {
				/* 826 */ e.setCancelled(true);
				/* 827 */ p.closeInventory();
				/* 828 */ p.chat("/kit lumberjack");
				/* 829 */ return;
				/*      */ }
			/* 831 */ if (e.getCurrentItem().getType() == Material.STONE_PICKAXE)
			/*      */ {
				/* 833 */ e.setCancelled(true);
				/* 834 */ p.closeInventory();
				/* 835 */ p.chat("/kit miner");
				/* 836 */ return;
				/*      */ }
			/* 845 */ if (e.getCurrentItem().getType() == Material.BLAZE_ROD)
			/*      */ {
				/* 847 */ e.setCancelled(true);
				/* 848 */ p.closeInventory();
				/* 849 */ p.chat("/kit monk");
				/* 850 */ return;
				/*      */ }
			/* 852 */ if (e.getCurrentItem().getType() == Material.EMERALD)
			/*      */ {
				/* 854 */ e.setCancelled(true);
				/* 855 */ p.closeInventory();
				/* 856 */ p.chat("/kit ninja");
				/* 857 */ return;
				/*      */ }
			/* 866 */ if (e.getCurrentItem().getType() == Material.WATER_BUCKET)
			/*      */ {
				/* 868 */ e.setCancelled(true);
				/* 869 */ p.closeInventory();
				/* 870 */ p.chat("/kit poseidon");
				/* 871 */ return;
				/*      */ }
			/* 866 */ if (e.getCurrentItem().getType() == Material.NETHER_STAR)
			/*      */ {
				/* 868 */ e.setCancelled(true);
				/* 869 */ p.closeInventory();
				/* 870 */ p.chat("/kit blink");
				/* 871 */ return;
				/*      */ }
			/* 866 */ if (e.getCurrentItem().getType() == Material.getMaterial(148))
			/*      */ {
				/* 868 */ e.setCancelled(true);
				/* 869 */ p.closeInventory();
				/* 870 */ p.chat("/kit aladdin");
				/* 871 */ return;
				/*      */ }
			/* 873 */ if (e.getCurrentItem().getType() == Material.IRON_AXE)
			/*      */ {
				/* 875 */ e.setCancelled(true);
				/* 876 */ p.closeInventory();
				/* 877 */ p.chat("/kit viking");
				/* 878 */ return;
				/*      */ }
			/* 880 */ if (e.getCurrentItem().getType() == Material.LAVA_BUCKET)
			/*      */ {
				/* 882 */ e.setCancelled(true);
				/* 883 */ p.closeInventory();
				/* 884 */ p.chat("/kit fireman");
				/* 885 */ return;
				/*      */ }
			/* 887 */ if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK)
			/*      */ {
				/* 889 */ e.setCancelled(true);
				/* 890 */ p.closeInventory();
				/* 891 */ p.chat("/kit specialist");
				/* 892 */ return;
				/*      */ }
			/* 901 */ if (e.getCurrentItem().getType() == Material.WOOD_HOE)
			/*      */ {
				/* 903 */ e.setCancelled(true);
				/* 904 */ p.closeInventory();
				/* 905 */ p.chat("/kit reaper");
				/* 906 */ return;
				/*      */ }
			/* 915 */ if (e.getCurrentItem().getType() == Material.WEB)
			/*      */ {
				/* 917 */ e.setCancelled(true);
				/* 918 */ p.closeInventory();
				/* 919 */ p.chat("/kit snail");
				/* 920 */ return;
				/*      */ }
			/* 985 */ if (e.getCurrentItem().getType() == Material.MAGMA_CREAM)
			/*      */ {
				/* 987 */ e.setCancelled(true);
				/* 988 */ p.closeInventory();
				/* 989 */ p.chat("/kit booster");
				/* 990 */ return;
				/*      */ }
			/* 985 */ if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE)
			/*      */ {
				/* 987 */ e.setCancelled(true);
				/* 988 */ p.closeInventory();
				/* 989 */ p.chat("/kit madman");
				/* 990 */ return;
				/*      */ }
			/* 1020 */ if (e.getCurrentItem().getType() == Material.IRON_HOE)
			/*      */ {
				/* 1022 */ e.setCancelled(true);
				/* 1023 */ p.closeInventory();
				/* 1024 */ p.chat("/kit bloodgun");
				/* 1025 */ return;
				/*      */ }
			/* 1020 */ if (e.getCurrentItem().getType() == Material.IRON_BOOTS)
			/*      */ {
				/* 1022 */ e.setCancelled(true);
				/* 1023 */ p.closeInventory();
				/* 1024 */ p.chat("/kit stomper");
				/* 1025 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.POTION)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit urgal");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.STONE_AXE)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit thor");
				/* 1032 */ return;
				/*      */ }
			 if (e.getCurrentItem().getType() == Material.REDSTONE_TORCH_ON)
				/*      */ {
					/* 1029 */ e.setCancelled(true);
					/* 1030 */ p.closeInventory();
					/* 1031 */ p.chat("/kit flash");
					/* 1032 */ return;
					/*      */ }
			 if (e.getCurrentItem().getType() == Material.RAW_CHICKEN)
				/*      */ {
					/* 1029 */ e.setCancelled(true);
					/* 1030 */ p.closeInventory();
					/* 1031 */ p.chat("/kit cannibal");
					/* 1032 */ return;
					/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.SNOW_BALL)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit switcher");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.TNT)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit tank");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.WATCH)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit timelord");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit turtle");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.SPIDER_EYE)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit viper");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.DIRT)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit worm");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.SPONGE)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit launcher");
				/* 1032 */ return;
				/*      */ }
			/*      */ }
		/*      */ }
	/*      */ }

/*
 * Location: C:\Users\not\Desktop\HungerGames.jar!\me\duex\GUI\GUI1.class Java
 * compiler version: 7 (51.0) JD-Core Version: 0.7.1
 */