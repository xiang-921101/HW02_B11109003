package com.example.test4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val places = listOf(
        Place("Statue of Liberty", "自由女神像是法國在1876年贈送給美國的獨立100周年禮物，位於美國紐約市哈德遜河口附近。自由女神像高46米，加基座為93米，重200多噸，是金屬鑄造，置於一座混凝土製的台基上。自由女神穿著古希臘風格服裝，頭帶光芒四射冠冕，七道尖芒意味著七大洲。右手高舉代表自由的火炬，左手捧著《獨立宣言》；腳下是打碎的手銬、腳鐐和鎖鏈，象徵著掙脫暴政的約束和自由。一個多世紀以來，聳立在自由島上的自由女神銅像已成為美利堅民族和美法人民的友誼象徵，永遠表達著美國人民爭取民主、嚮往自由的崇高理想。", R.drawable.statue_of_liberty, 40.6892, -74.0445),
        Place("Eiffel Tower", "埃菲爾鐵塔於1889年建成，矗立在塞納河岸法國巴黎的戰神廣場，它是法國文化象徵之一、巴黎城市地標之一、巴黎最高建築物，被法國人愛稱為「鐵娘子」。埃菲爾鐵塔得名於設計它的著名建築師、結構工程師古斯塔夫·埃菲爾，全部由施耐德鐵器建造，全高300米，天線高24米，總高324米，由很多分散的鋼鐵構建組成，看起來就像一堆模型組建。其中鋼鐵構建有18038個，重達10000噸，使用鉚釘250萬個。除了四個腳是鋼筋水泥之外，全身都用鋼鐵構成，塔身總重量7000噸。塔分三樓，分別在離地面57.6米、115.7米和276.1米處，一、二樓設有餐廳，三樓建有景觀台，從塔座到塔頂共有1711級階梯。", R.drawable.eiffel_tower, 48.8584, 2.2945),
        Place("Big Ben", "大笨鐘建於1858年，是英國倫敦著名的古鐘。安裝在西敏寺橋北議會大廈東側高95米的鐘樓上。大鐘由當年負責公務的專員本傑明爵士監製，名為「大本」。鐘重14噸，鐘盤直徑7米，時針和分針長度分別為2.75米和4.27米，鐘擺重305公斤，每走一小時，發出深沉而又鏗鏘的報時聲，每15分鐘響一次。1923年起，通過廣播，鐘聲遠及世界各地。", R.drawable.big_ben, 51.5007,  -0.1246),
        Place("Great Wall", "萬里長城是中國古代的軍事防禦工程，自戰國時期開始，修築長城一直是一項大工程。據記載，秦王使用了近百萬勞動力修築長城，占全國人口的1/20。長城資源主要分佈在河北、北京、天津、山西、陝西、甘肅、內蒙古、黑龍江、吉林、遼寧、山東、河南、青海、寧夏、新疆等15個區省市。長城連續修築時間之長，工程之大，施工之艱巨，歷史文化內涵之豐富，是世界其他古代工程難以相比的。", R.drawable.great_wall, 40.3574,  116.0202),
        Place("Red Square in Moscow", "紅場是俄羅斯首都莫斯科市中心的著名廣場，位於莫斯科市中心，西南與克裡姆林宮殿相毗連。原是前蘇聯重要節日舉行群眾集會和閱兵的地方。辟於十五世紀末，十七世紀後半期取今名。平面長方形，面積約4公頃。西側是克里姆林宮，北面為國立歷史博物館，東側為百貨大樓，南部為瓦西裡不拉仁教堂，臨莫斯科河。列寧陵墓位於靠宮牆一面的中部。墓上為檢閱台，兩旁為觀禮台。", R.drawable.red_square_in_moscow, 55.7539, 37.6208),
        Place("Leaning Tower of Pisa", "比薩斜塔是義大利比薩城大教堂的獨立式鐘樓，位於義大利托斯卡納省比薩城北面的奇跡廣場上。比薩斜塔從地基到塔頂高58.36米，從地面到塔頂高55米，鐘樓牆體在地面上寬度是4.09米，在塔頂寬2.48米，總重約14453噸，重心在地基上方22.6米處。圓形基地面積為285平方米，對地面的平均壓強為497千帕。傾斜角度3.99度，偏離地基外沿2.5米，頂層突出4.5米。1987年它和相鄰的大教堂、洗禮堂、墓園一起因其對11世紀至14世紀對義大利建築藝術的巨大影響，而被聯合國教育科學文化組織評選為世界遺產。", R.drawable.leaning_tower_of_pisa,  43.7231, 10.3966),
        Place("Taj Mahal", "泰姬陵是印度最著名的古跡之一，在今印度距新德里200多公里外的北方邦的阿格拉（Agra）城內，亞穆納河右側。是莫臥兒王朝第5代皇帝沙賈汗爲了紀念他已故的皇后阿姬曼·芭奴而建立的陵墓，被譽為「完美建築」。由殿堂、鐘樓、尖塔、水池等構成，全部用純白色的大理石建築，用玻璃、瑪瑙鑲嵌，絢麗奪目、美麗無比。2007年7月7日，成為世界七大奇跡之一。", R.drawable.taj_mahal, 27.1751, 78.0421),
        Place("Jesus Christ", "巴西基督像是一座裝飾藝術風格的大型耶穌基督雕像，位於巴西里約熱內盧，是這座城市的標誌。它張開雙臂歡迎來自世界各地的遊客，是巴西人民熱情接納和寬闊胸懷的象徵，也是世界最聞名的紀念雕塑之一。這尊雕像體積龐大，有200噸重，左右手的指間距達23米，雕像中耶穌基督身著長袍，雙臂平舉，深情地俯瞰山下裡約熱內盧市的美麗全景，預示著博愛精神。", R.drawable.jesus_christ, 22.9519, 43.2105),
        Place("Machu Picchu","有著「天空之城」稱號的馬丘比丘，坐落於海拔超過兩千公尺的山脊上，可是代表印加文明的世界級遺產，許多人前往秘魯就是為了一睹這座失落之城的面貌。",R.drawable.machu_picchu,-13.1631,-72.5450),
        Place("Blue Lagoon","藍湖是全世界最大的露天溫泉，夢幻藍色湖面是經由礦物、海藻、陽光與水面反射而形成，邊泡澡一邊欣賞遠處山景也太愜意，來冰島除了看極光，也別忘記去藍湖享受一下！",R.drawable.blue_lagoon,63.8804,22.4496),
        Place("Königssee","國王湖是德國最出名的的湖泊，也是許多人心目中的夢幻聖地！下湖區紅屋教堂是熱門打卡點，如同鏡子一般清澈，隨著太陽變換的湖景和倒影，晴空萬里時就像一幅畫十分浪漫，非常適合搭乘遊船渡過愜意的午後時光。",R.drawable.k_nigssee,47.5553,12.9868),
        Place("Waitomo Cave","世界第九大奇蹟的懷托摩螢火蟲洞宛如洞穴裡藏的璀璨星空，是紐西蘭的超熱門景點，不同於海景山景的壯闊景致，螢火蟲洞的魅力如同小精靈一樣既神秘又浪漫。",R.drawable.waitomo_cave,-38.2593,175.1006 ),
        Place("Wineglass Bay","來到澳洲的塔斯馬尼亞州，一定不能錯過菲欣納國家公園（Freycinet Peninsula）裡的酒杯灣！在海岸劃出完美的純白弧線，俯瞰就如同酒杯一般，壯闊海景讓人身心靈都得以沉澱。",R.drawable.wineglass_bay,-42.1486,148.3100 ),
        Place("Plitvice Lakes National Park","十六湖國家公園以特殊的「喀斯特地形」聞名，石灰岩沈積形成許多高低落差不同的湖泊、洞穴、瀑布等地形，綠樹更是隨著四季變化不同面貌，每次去都能感受到不同的視覺饗宴。",R.drawable.plitvice_lakes_national_park,44.8803 ,15.6160),
        Place("Perito Moreno Glacier","「會移動的絕美冰川」莫雷諾冰川位於冰川國家公園（Los Glaciares National Park）裡，不論從哪個角度看都是視覺震撼，能夠超近距離觀賞這雄偉冰河，一定永生難忘。",R.drawable.perito_moreno_glacier,50.4943,73.0523),
        Place("Rainbow Mountain","同樣位於秘魯的彩虹山也是近年來爆紅的夢幻景點之一，經流水侵蝕與風化作用形成的丹霞地貌，在2016年融雪以絢爛之姿現身，層層堆疊的彩虹色奇景頓時成為旅遊話題焦點。",R.drawable.rainbow_mountain,-13.8700,-71.3029)

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PlaceAdapter(places) { place ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("place", place)
            startActivity(intent)
        }
    }
}