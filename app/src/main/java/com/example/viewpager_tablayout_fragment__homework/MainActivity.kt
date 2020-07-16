package com.example.viewpager_tablayout_fragment__homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.information_button.view.*
import kotlinx.android.synthetic.main.community_button.view.*
import kotlinx.android.synthetic.main.custom_view.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentList = listOf(fragment1(), fragment2(), fragment3())

        val adapter = FragmentAdapter(supportFragmentManager, 1)
        adapter.fragmentList = fragmentList
        viewPager.adapter = adapter //앞에껀 아까 만든 뷰페이져 아이디
        tabLayout.setupWithViewPager(viewPager) //탭레이아웃과 뷰랑도 연결 즉 뷰페이저는 Adapter를 통한 프래그먼트와 이것을통한 탭과 둘다 연동
        //이거 하는순간 내가 첨에 디자인에서 끌어와던 내용 사라진 형시 이제 탭 이미지 만들어 주기
        tabLayout.getTabAt(0)?.setCustomView(createView("홈"))
        tabLayout.getTabAt(1)?.setCustomView(createView("내정보"))
        tabLayout.getTabAt(2)?.setCustomView(createView("커뮤니티"))
    }

    fun createView(tabName: String): View {
        val tabView = LayoutInflater.from(this).inflate(R.layout.custom_view, null)
        tabView.text_custom1.text = tabName
        when (tabName) {
            "홈" -> {
                tabView.image_custom1.setImageResource(R.drawable.browser)
            }
            "내정보" -> {
                tabView.image_custom1.setImageResource(R.drawable.contact)
            }
            "커뮤니티" -> {
                tabView.image_custom1.setImageResource(R.drawable.support)
            }
            else -> {
                return tabView
            }
        }
        return tabView
    }

}

