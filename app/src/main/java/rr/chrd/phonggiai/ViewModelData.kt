package rr.chrd.phonggiai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import rr.chrd.phonggiai.Models.EthicsModel
import rr.chrd.phonggiai.Models.RulesModel
import rr.chrd.phonggiai.Models.TipsModel

class ViewModelData: ViewModel() {

    private val baccaratTitle = MutableLiveData<String>().apply {

        value = "Baccarat là gì"
    }

    private val baccaratDesc = MutableLiveData<String>().apply{

        value = "Baccarat là một trò chơi bài được chơi trong các sòng bạc. Nó là một trò chơi bài" +
                " so sánh được chơi giữa hai tay của người chơi và nhà cái. Mỗi vòng của cuộc đảo" +
                " chính baccarat có ba kết quả có thể xảy ra: người chơi có số điểm cao hơn, " +
                "chủ ngân hàng và hòa. Có ba biến thể phổ biến của trò chơi: banco điểm hoặc " +
                "baccarat Bắc Mỹ, ngược lại cả hai người chơi đều có quyền lựa chọn." +
                " Tỷ lệ thắng nghiêng về ngân hàng và nhà cái ít nhất là 1%. Nguồn gốc của trò chơi" +
                " đang gây tranh cãi, với một số nguồn tin cho biết nó có từ thế kỷ 19. " +
                "Các nguồn tin khác cho biết trò chơi được giới thiệu đến Pháp từ Ý bởi những " +
                "người lính trở về từ Chiến tranh Pháp-Ý dưới thời trị vì của Charles VIII vào" +
                " cuối thế kỷ 15."
    }

    private  val winTitle = MutableLiveData<String>().apply {

        value ="CÁCH THẮNG BACCARAT TẠI CASINO"
    }

    private val winDesc = MutableLiveData<String>().apply {

        value = "Để thực sự đắm mình trong các buổi biểu diễn đẳng cấp thế giới, " +
                "các nhà hàng từng đoạt giải thưởng và cuộc sống về đêm tốt nhất mà Las Vegas mang lại," +
                " bạn phải học cách chơi baccarat và giành chiến thắng như một chuyên gia vững vàng." +
                " Nếu bạn muốn ngồi vào các trò chơi trên bàn của sòng bạc ở Las Vegas, " +
                "thì baccarat là trò chơi nên làm của bạn với độ phức tạp của trò chơi phong phú" +
                " và thú vui cờ bạc kiểu James Bond. Có ba kết quả có thể xảy ra - người chơi thắng," +
                " Nhà cái thắng và hòa - và chủ ngân hàng thực hiện hầu hết công việc. " +
                "Như người dẫn chương trình Jeff Civillico giải thích trong video hướng dẫn bên dưới," +
                " người chơi có thể đặt cược vào bên người chơi, bên của “chủ ngân hàng”" +
                " (hay còn gọi là nhà cái) hoặc đặt cược hòa. Các thẻ từ 2 đến 9 có mệnh giá trong" +
                " khi các thẻ 10, J, Q và King có mệnh giá bằng 0. Một con át chủ bài có giá trị một."
    }

    val bTitle : LiveData<String> = baccaratTitle
    val bDesc : LiveData<String> = baccaratDesc

    val wTitle : LiveData<String> =  winTitle
    val wDesc : LiveData<String> = winDesc


    private var ethicsList = ArrayList<EthicsModel>()

    private var ethicsDesc = arrayListOf(

        "Khi chơi xong, bạn có thể yêu cầu nhà cái che chắn cho mình trước khi rời bàn.",

        "Xem cược của riêng bạn mọi lúc. Cược Baccarat rất dễ theo dõi khi bạn tự xử lý các ván cược và đặt chúng trực tiếp trước mặt bạn",

        "Đừng ép vào một bàn đông đúc. nếu bàn đông, hãy hỏi người chơi gần nhất xem anh ta có phiền không nếu bạn tham gia cùng họ",

        "Đừng làm chậm trận đấu bằng cách liên tục hỏi người chia bài câu hỏi cơ bản về cách trò chơi" +
                " được chơi hoặc cách đặt cược điên cuồng như thế nào. Có hàng trăm cuốn sách về cách" +
                " chơi baccarat bao gồm cuốn sách này. Bạn nên tìm hiểu các khoản thanh toán chính xác" +
                " cho các cược bạn sẽ thực hiện.",

        "Cố gắng rời rạc về chiến thắng và thua lỗ của bạn. Không ai thực sự quan tâm đến việc" +
                " bạn đang thắng bao nhiêu, và bạn không có ích gì khi quảng cáo rằng bạn là người" +
                " chiến thắng nhất quán",

        "Trong khi chơi, hãy cư xử lịch sự mọi lúc. Nếu bạn uống rượu," +
                " hãy tránh lạm dụng nó và đừng bao giờ say. Bạn sẽ cần phải tỉnh táo" +
                " để thực hiện chính xác các cược theo yêu cầu của Ultimate Baccarat Sstrategy," +
                " và trái với ý kiến của một số người say rượu, rượu không giúp bạn suy nghĩ sáng suốt hơn"
    )

    private var ethicsInfo = MutableLiveData<List<EthicsModel>>()
     val thcsNf : LiveData<List<EthicsModel>>
    get() = ethicsInfo

    private val etError = CoroutineExceptionHandler { _, _ ->
        ethicsInfo.postValue(null)
    }
    fun ethicsFun() : MutableLiveData<List<EthicsModel>>{
        viewModelScope.launch(etError + Dispatchers.IO){
            for (n in 0 until ethicsDesc.size){
                ethicsList.add(EthicsModel(ethicsDesc[n]))
            }
            ethicsInfo.postValue(ethicsList)
        }
        return  ethicsInfo
    }

    private var rulesList = ArrayList <RulesModel>()

    private var rulesDesc = arrayListOf(

        "Luật chơi rất đơn giản, vì tất cả các quân bài tham gia trò chơi đều có một giá trị" +
                " nhất định, được tính như sau. 1-9 có mệnh giá bằng số điểm của thẻ. 10, Jack," +
                " Queen và King đều được tính là 0. A được tính là 1.",

        "Người chia bài lần lượt chia hai lá bài cho người chia bài và người chơi. Người có số 9" +
                " gần nhất sẽ thắng lượt. Baccarat trực tuyến thời gian thực không khác với các" +
                " quy tắc ban đầu, vì nó gần như giống nhau ở mọi nơi. Sau đó đặt cược hành động",

        "Nếu bạn đặt cược bên người chơi và người chơi thắng, tiền cược sẽ được nhân đôi. " +
                "Nếu bạn đặt cược vào phía nhà cái, bạn sẽ nhận được 95% tiền cược của mình." +
                " Nếu bạn đặt cược vào phía nhà cái, bạn sẽ nhận được 95% tiền cược của mình." +
                " Nếu cả hai người tham gia được 8 hoặc 9, họ sẽ chỉ đứng lên và không ai thắng." +
                " Nếu người chơi có ít hơn hoặc bằng năm lá bài, người chơi lấy một lá bài khác" +
                " hoặc người chơi đứng. Nếu người chơi đang đứng, cược từ nhà cái là 5 hoặc ít hơn.",

        "Lựa chọn cuối cùng là hòa và áp dụng phân phối 8 ăn 1. Bàn trò chơi trực tuyến baccarat " +
                "cũng cung cấp tỷ lệ cược và manh mối để đặt cược, vì vậy người chơi luôn có thể kiểm" +
                " tra tỷ lệ cược."
    )


    private var rulesInfo = MutableLiveData<List<RulesModel>>()
    val rlsNf : LiveData<List<RulesModel>>
    get() = rulesInfo
    private val errorR = CoroutineExceptionHandler { _, _ ->
        rulesInfo.postValue(null)
    }
    fun rulesFun(): MutableLiveData<List<RulesModel>>{
        viewModelScope.launch(errorR + Dispatchers.IO){
            for (n in rulesDesc.indices){
                rulesList.add(RulesModel(rulesDesc[n]))
            }
            rulesInfo.postValue(rulesList)
        }
        return  rulesInfo
    }


    private var tipsList = ArrayList<TipsModel>()


    private var tipsTitle = arrayListOf(

        "Khi bạn đang trong tình trạng thua lỗ, bạn có thể bỏ cuộc.",
        "Bạn có thể thay đổi giá trị cược của mình",
        "Bạn có thể chọn nơi để chơi.",
        "Bạn có thể thay đổi chiến lược của mình dựa trên kết quả bảng và sự may rủi",
        "Bạn có thể sử dụng kỷ luật bản thân nghiêm ngặt để phát triển một kế hoạch chiến" +
                " thắng tốt và cố gắng gắn bó với nó."
    )


    private var tipsDesc = arrayListOf(
        "Nếu bạn đang trong một chuỗi trận thua, bạn có thể nghỉ ngơi một chút và trở lại sau." +
                " Đó là lỗi của người chơi nếu họ thua bởi vì họ quá lì lợm đến mức không dừng" +
                " lại khi đang thua.",

        "Bạn luôn có thể thay đổi giá trị đặt cược của mình. nếu bạn đang trong một chuỗi chiến thắng," +
                " bạn có thể tăng đặt cược của mình để có thêm lợi nhuận. nhưng, nếu bạn đang thua." +
                " có thể giảm giá trị đặt cược của bạn một chút. cho đến khi bạn thu thập lại may mắn" +
                " của mình.",

        "Bạn có thể thay đổi vị trí tùy thuộc vào tình hình. Nếu bạn cảm thấy bàn trống và bạn không thắng," +
                " hãy đứng dậy và nhảy sang bàn khác, có thể vận may của bạn đang ở bàn kia.",

        "Mỗi bảng cuối cùng sẽ phát triển các xu hướng khác nhau tại các thời điểm khác nhau." +
                " Một số bảng ủng hộ những người chơi chơi số, trong khi những bàn khác ủng hộ" +
                " những người chơi đặt cược từ bên lề. bạn có thể điều chỉnh phong cách trò chơi" +
                " của bạn tùy thuộc vào may mắn của bạn. Bàn nào đó thô kệch, chẳng ưa thích ai." +
                " Bạn có thể điều chỉnh chiến lược chơi của mình tùy theo sự thay đổi của các sự kiện " +
                "trong bảng đã nói.",

        "Nhà cái sòng bạc có chiến lược cuối cùng. Chính cấu trúc của các trò chơi sòng bạc thể hiện" +
                " một thiết kế được lên kế hoạch cẩn thận về cách họ sẽ thu được lợi nhuận Vì vậy," +
                " chiến thắng trong trò chơi baccarat đòi hỏi một sự tự giác mạnh mẽ Một khi " +
                "bạn đã đạt được sự tự tin khi chơi. Bạn sẽ cố gắng đánh bại lợi thế của sòng bạc" +
                " trước những người chơi."
    )

    private val tipsInfo = MutableLiveData<List<TipsModel>>()
    val tpsNf : LiveData<List<TipsModel>>
    get() = tipsInfo

    private val errorT = CoroutineExceptionHandler { _, _ ->
        tipsInfo.postValue(null)
    }

    fun tipsFun() : MutableLiveData<List<TipsModel>>{
        viewModelScope.launch(errorT + Dispatchers.IO){
            for (n in 0 until tipsTitle.size)
                tipsList. add((TipsModel(tipsTitle[n],tipsDesc[n])))
            tipsInfo.postValue(tipsList)
        }
        return tipsInfo
    }
}