package com.bc.lottery.common.utils;


import com.bc.lottery.common.utils.mapper.JsonMapper;

import java.util.LinkedHashMap;

public class JsonTest {


    public static void main(String[] args) {
        JsonMapper jsonMapper = JsonMapper.defaultMapper();
        String json = "{\"sn_data\":{\"OW-L0-U1-L3\":{\"action\":\"add\",\"cmd\":\"broadcast_store\",\"page_id\":3,\"page_index\":2,\"pages\":{\"1\":{\"15885_path_1_1530176922456\":{\"_type\":\"draw_line\",\"id\":\"15885_path_1_1530176922456\",\"is_new_added\":true,\"pathString\":\"M 191 204 Q 192 204 192 204 Q 288 211 299 214 Q 335 221 347 225 Q 424 247 428 248 Q 450 254 457 256 Q 488 266 491 266 Q 496 268 498 269 Q 502 270 503 270 Q 505 271 505 271 L 505 271\",\"stroke\":\"#fe4b5a\",\"strokeWidth\":4},\"15885_path_2_1530176943741\":{\"_type\":\"draw_line\",\"id\":\"15885_path_2_1530176943741\",\"is_new_added\":true,\"pathString\":\"M 168 484 Q 169 484 169 484 L 701 485\",\"stroke\":\"#fe4b5a\",\"strokeWidth\":4}},\"2\":{\"15885_path_1_1530176972009\":{\"_type\":\"draw_line\",\"id\":\"15885_path_1_1530176972009\",\"is_new_added\":true,\"pathString\":\"M 543 343 Q 544 343 543 343 Q 337 347 333 350 Q 320 359 316 362 Q 292 388 291 390 Q 286 403 286 407 Q 285 416 285 420 Q 285 430 286 437 Q 295 455 299 460 Q 326 491 333 497 Q 365 520 372 525 Q 394 537 401 540 Q 432 549 438 550 Q 454 550 460 550 Q 482 543 487 541 Q 508 528 511 526 Q 521 519 524 516 Q 535 511 538 509 Q 544 506 546 505 Q 555 501 557 501 Q 570 498 573 497 Q 586 494 592 494 Q 659 495 659 495 Q 660 498 660 498 Q 660 501 659 502 Q 657 505 657 508 Q 655 512 653 515 Q 650 521 649 523 Q 635 543 632 546 Q 625 556 622 558 Q 613 567 610 569 Q 604 572 601 574 Q 596 577 583 581 Q 564 585 562 586 Q 556 586 554 586 Q 506 579 504 578 Q 496 565 495 562 Q 493 550 492 547 Q 492 536 492 532 Q 492 512 492 509 Q 494 500 501 484 Q 515 458 519 454 Q 541 425 548 417 Q 562 402 568 396 Q 591 376 594 374 Q 603 368 604 367 Q 608 365 609 364 Q 611 364 611 364 Q 619 362 619 362 L 620 362\",\"stroke\":\"#fe4b5a\",\"strokeWidth\":4},\"15885_path_2_1530176988028\":{\"_type\":\"draw_line\",\"id\":\"15885_path_2_1530176988028\",\"is_new_added\":true,\"pathString\":\"M 581 187 Q 582 187 582 187 Q 613 193 621 194 Q 645 200 653 203 Q 718 228 722 229 Q 738 235 744 238 Q 759 243 763 245 Q 774 249 775 250 Q 778 250 778 250 L 780 250\",\"stroke\":\"#fe4b5a\",\"strokeWidth\":4}},\"3\":{\"15885_path_1_1530177043356\":{\"_type\":\"draw_line\",\"id\":\"15885_path_1_1530177043356\",\"is_new_added\":true,\"pathString\":\"M 235 348 Q 236 348 235 349 Q 237 350 240 350 Q 272 360 279 362 Q 302 372 310 375 Q 323 380 329 382 Q 346 387 347 388 Q 354 389 357 390 Q 366 393 367 393 L 370 393\",\"stroke\":\"#fe4b5a\",\"strokeWidth\":4},\"15885_path_2_1530177044667\":{\"_type\":\"draw_line\",\"id\":\"15885_path_2_1530177044667\",\"is_new_added\":true,\"pathString\":\"M 722 178 Q 723 178 723 179 Q 723 184 723 186 Q 723 194 723 200 Q 723 220 722 229 Q 717 257 715 269 Q 706 303 704 317 Q 695 354 692 368 Q 681 409 677 423 Q 666 464 663 478 Q 650 525 649 532 Q 642 556 642 557 Q 638 568 638 571 Q 636 577 636 578 Q 634 581 634 581 L 634 579\",\"stroke\":\"#fe4b5a\",\"strokeWidth\":4}}},\"sender_id\":15885,\"sender_role\":\"teacher\",\"target_id\":\"15885_path_2_1530177044667\",\"target_type\":\"shape\",\"tools\":null}}}";

        LinkedHashMap<String,Object> map = jsonMapper.fromJson(json, LinkedHashMap.class);

        LinkedHashMap<String,Object> map2 = (LinkedHashMap<String,Object>)map.get("sn_data");

        LinkedHashMap<String,Object> map3 = (LinkedHashMap<String,Object>)map2.get("OW-L0-U1-L3");

        LinkedHashMap<String,Object> map4 = (LinkedHashMap<String,Object>)map3.get("pages");
        LinkedHashMap<String,Object> map5 = (LinkedHashMap<String,Object>)map4.get("1");

//        System.out.println(map5);
        map5.forEach((k,v)->{
//            System.out.println(k+":"+v);
        });

    }
}
