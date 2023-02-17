package com.naqswell.allfootball.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.snackbar.Snackbar
import com.naqswell.allfootball.R
import com.naqswell.allfootball.data.entities.fixtures.FixturesResult
import com.naqswell.allfootball.databinding.MatchesRvItemBinding

class MatchesAdapter(
    private var fixtures: ArrayList<FixturesResult>,
    private val onItemClickListener: (fixture: FixturesResult) -> Unit
) : RecyclerView.Adapter<MatchesAdapter.MatchesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = MatchesRvItemBinding.inflate(inflater, parent, false)
        return MatchesHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MatchesHolder, position: Int) {
        holder.onBind(fixtures[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(fixtures[position])
        }
    }

    override fun getItemCount() = fixtures.size


    class MatchesHolder(
        private val binding: MatchesRvItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var fixture: FixturesResult

        fun onBind(fixture: FixturesResult) {
            this.fixture = fixture
            loadImages()
            with(binding) {
                txtInGame.apply {
                    if (fixture.eventLive == null) {
                        txtInGame.visibility = View.INVISIBLE
                    }
                    else {
                        if (fixture.eventLive!!.toInt() == 1) {
                            txtInGame.visibility = View.VISIBLE
                        }
                    }
                }

                txtLeagueName.apply {
                    text = fixture.leagueName?.uppercase()
                    setOnClickListener {
                        Snackbar.make(it, text, Snackbar.LENGTH_SHORT)
                            .setAction("Ok") {}
                            .setActionTextColor(context.resources.getColor(R.color.peach_darker))
                            .show()
                    }
                }

                txtCountryName.apply {
                    text = fixture.countryName?.uppercase()
                    setOnClickListener {
                        Snackbar.make(it, text, Snackbar.LENGTH_SHORT)
                            .setAction("Ok") {}
                            .setActionTextColor(context.resources.getColor(R.color.peach_darker))
                            .show()
                    }
                }
                txtEventFinalResult.apply {
                    text = when (val time = fixture.eventFinalResult) {
                        "-" -> {
                            "Not played"
                        }
                        else -> time
                    }
                }
                txtEventTime.text = fixture.eventTime
                txtHomeTeam.apply {
                    text = fixture.eventHomeTeam
                    setOnClickListener {
                        Snackbar.make(it, text, Snackbar.LENGTH_SHORT)
                            .setAction("Ok") {}
                            .setActionTextColor(context.resources.getColor(R.color.peach_darker))
                            .show()
                    }
                }
                txtAwayTeam.apply {
                    text = fixture.eventAwayTeam
                    setOnClickListener {
                        Snackbar.make(it, text, Snackbar.LENGTH_SHORT)
                            .setAction("Ok") {}
                            .setActionTextColor(context.resources.getColor(R.color.peach_darker))
                            .show()
                    }
                }
            }
        }

        private fun loadImages() {
            Glide.with(itemView.context)
                .load(fixture.homeTeamLogo)
                .fitCenter()
                .transition(DrawableTransitionOptions.withCrossFade())
//                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .into(binding.imgHomeTeam)

            Glide.with(itemView.context)
                .load(fixture.awayTeamLogo)
                .fitCenter()
                .transition(DrawableTransitionOptions.withCrossFade())
//                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .into(binding.imgAwayTeam)

            Glide.with(itemView.context)
                .load(fixture.countryLogo)
                .fitCenter()
                .transition(DrawableTransitionOptions.withCrossFade())
//                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .into(binding.imgCountry)
        }
    }
}