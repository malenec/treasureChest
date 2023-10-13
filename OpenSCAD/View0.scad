union()
{
    difference()
    {
        difference()
        {
            translate([-32.5, 0.0, 20.0])
            {
                rotate([0.0, 90.0, 0.0])
                {
                    linear_extrude(height = 65.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([65.0, 65.0])
                        {
                            M644();
                        }
                    }
                }
            }
            translate([0.0, 0.0, 20.0])
            {
                linear_extrude(height = 32.5, twist = 0.0, scale = 1.0, slices = 1, center = false)
                {
                    scale([65.0, 65.0])
                    {
                        M8();
                    }
                }
            }
        }
        translate([-30.0, 0.0, 22.5])
        {
            rotate([0.0, 90.0, 0.0])
            {
                linear_extrude(height = 60.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                {
                    scale([60.0, 60.0])
                    {
                        M644();
                    }
                }
            }
        }
    }
    union()
    {
        translate([6.5, 31.25, 22.25])
        {
            rotate([0.0, 0.0, 90.0])
            {
                rotate([90.0, 0.0, 0.0])
                {
                    union()
                    {
                        rotate([0.0, 0.0, 180.0])
                        {
                            difference()
                            {
                                difference()
                                {
                                    linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                    {
                                        scale([8.5, 8.5])
                                        {
                                            M644();
                                        }
                                    }
                                    linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                    {
                                        scale([4.5, 4.5])
                                        {
                                            M662();
                                        }
                                    }
                                }
                                linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                {
                                    rotate(-180.0)
                                    {
                                        M739();
                                    }
                                }
                            }
                        }
                        translate([0.0, 0.0, 10.0])
                        {
                            rotate([0.0, 0.0, 180.0])
                            {
                                difference()
                                {
                                    difference()
                                    {
                                        linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                        {
                                            scale([8.5, 8.5])
                                            {
                                                M644();
                                            }
                                        }
                                        linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                        {
                                            scale([4.5, 4.5])
                                            {
                                                M662();
                                            }
                                        }
                                    }
                                    linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                    {
                                        rotate(-180.0)
                                        {
                                            M739();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        translate([-27.0, 0.0, 0.0])
        {
            translate([6.5, 31.25, 22.25])
            {
                rotate([0.0, 0.0, 90.0])
                {
                    rotate([90.0, 0.0, 0.0])
                    {
                        union()
                        {
                            rotate([0.0, 0.0, 180.0])
                            {
                                difference()
                                {
                                    difference()
                                    {
                                        linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                        {
                                            scale([8.5, 8.5])
                                            {
                                                M644();
                                            }
                                        }
                                        linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                        {
                                            scale([4.5, 4.5])
                                            {
                                                M662();
                                            }
                                        }
                                    }
                                    linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                    {
                                        rotate(-180.0)
                                        {
                                            M739();
                                        }
                                    }
                                }
                            }
                            translate([0.0, 0.0, 10.0])
                            {
                                rotate([0.0, 0.0, 180.0])
                                {
                                    difference()
                                    {
                                        difference()
                                        {
                                            linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                            {
                                                scale([8.5, 8.5])
                                                {
                                                    M644();
                                                }
                                            }
                                            linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                            {
                                                scale([4.5, 4.5])
                                                {
                                                    M662();
                                                }
                                            }
                                        }
                                        linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                                        {
                                            rotate(-180.0)
                                            {
                                                M739();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    translate([26.4125, 26.384999999999998, 15.0])
    {
        linear_extrude(height = 5.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
        {
            scale([7.175, 7.23])
            {
                M8();
            }
        }
    }
}

module M739()
{
    polygon
    (
        points =
        [
            [0.0, 0.0], 
            [11.0, 0.0], 
            [10.905893475111915, 1.4357881144205675], 
            [10.62518408917975, 2.8470094961277286], 
            [10.162674857624154, 4.2095177560159875], 
            [9.526279441628825, 5.5], 
            [8.726886743203586, 6.696375719095928], 
            [7.778174593052023, 7.778174593052022], 
            [6.696375719095927, 8.726886743203586], 
            [5.499999999999999, 9.526279441628827]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        ]
    );
}

module M644()
{
    polygon
    (
        points =
        [
            [0.5, 0.0], 
            [0.49992384757819563, 0.008726203218641756], 
            [0.4996954135095479, 0.017449748351250485], 
            [0.4993147673772869, 0.026167978121471914], 
            [0.4987820251299121, 0.03487823687206265], 
            [0.4980973490458728, 0.04357787137382909], 
            [0.49726094768413664, 0.05226423163382673], 
            [0.496273075820661, 0.06093467170257374], 
            [0.4951340343707852, 0.06958655048003272], 
            [0.4938441702975689, 0.07821723252011543], 
            [0.492403876506104, 0.08682408883346518], 
            [0.490813591723832, 0.09540449768827242], 
            [0.48907380036690284, 0.10395584540887966], 
            [0.4871850323926176, 0.1124755271719325], 
            [0.48514786313799824, 0.12096094779983387], 
            [0.48296291314453416, 0.1294095225512604], 
            [0.48063084796915945, 0.13781867790849958], 
            [0.4781523779815178, 0.14618585236136836], 
            [0.47552825814757677, 0.1545084971874737], 
            [0.4727592877996584, 0.16278407722857835], 
            [0.46984631039295416, 0.17101007166283438], 
            [0.46679021324860087, 0.17918397477265013], 
            [0.4635919272833937, 0.18730329670795604], 
            [0.46025242672622013, 0.1953655642446369], 
            [0.45677272882130043, 0.20336832153790008], 
            [0.45315389351832497, 0.21130913087034972], 
            [0.4493970231495835, 0.2191855733945387], 
            [0.44550326209418395, 0.2269952498697734], 
            [0.4414737964294635, 0.2347357813929454], 
            [0.43730985356969787, 0.24240481012316853], 
            [0.4330127018922193, 0.25], 
            [0.42858365035105617, 0.2575190374550271], 
            [0.424024048078213, 0.26495963211660245], 
            [0.419335283972712, 0.27231951750751354], 
            [0.41451878627752087, 0.2795964517353734], 
            [0.4095760221444959, 0.286788218175523], 
            [0.4045084971874737, 0.29389262614623657], 
            [0.3993177550236464, 0.30090751157602413], 
            [0.39400537680336095, 0.30783073766282915], 
            [0.3885729807284854, 0.31466019552491875], 
            [0.383022221559489, 0.3213938048432697], 
            [0.377354790111386, 0.32802951449525364], 
            [0.3715724127386971, 0.3345653031794291], 
            [0.36567685080958523, 0.34099918003124924], 
            [0.35966990016932554, 0.3473291852294987], 
            [0.3535533905932738, 0.35355339059327373], 
            [0.3473291852294986, 0.3596699001693256], 
            [0.34099918003124924, 0.36567685080958523], 
            [0.3345653031794291, 0.3715724127386971], 
            [0.32802951449525364, 0.377354790111386], 
            [0.3213938048432697, 0.383022221559489], 
            [0.31466019552491875, 0.3885729807284854], 
            [0.30783073766282915, 0.394005376803361], 
            [0.3009075115760242, 0.3993177550236464], 
            [0.29389262614623657, 0.4045084971874737], 
            [0.286788218175523, 0.4095760221444959], 
            [0.2795964517353734, 0.41451878627752087], 
            [0.2723195175075136, 0.41933528397271197], 
            [0.26495963211660245, 0.42402404807821303], 
            [0.2575190374550272, 0.4285836503510561], 
            [0.24999999999999994, 0.43301270189221935], 
            [0.24240481012316856, 0.43730985356969787], 
            [0.23473578139294543, 0.44147379642946344], 
            [0.22699524986977343, 0.4455032620941839], 
            [0.21918557339453873, 0.4493970231495835], 
            [0.21130913087034972, 0.45315389351832497], 
            [0.20336832153790008, 0.45677272882130043], 
            [0.19536556424463686, 0.4602524267262202], 
            [0.1873032967079561, 0.4635919272833937], 
            [0.17918397477265008, 0.4667902132486009], 
            [0.1710100716628344, 0.46984631039295416], 
            [0.16278407722857827, 0.4727592877996584], 
            [0.15450849718747373, 0.47552825814757677], 
            [0.14618585236136838, 0.4781523779815178], 
            [0.13781867790849958, 0.48063084796915945], 
            [0.12940952255126037, 0.48296291314453416], 
            [0.12096094779983384, 0.48514786313799824], 
            [0.11247552717193246, 0.4871850323926176], 
            [0.10395584540887962, 0.48907380036690284], 
            [0.09540449768827246, 0.490813591723832], 
            [0.08682408883346511, 0.49240387650610407], 
            [0.07821723252011546, 0.4938441702975689], 
            [0.06958655048003273, 0.4951340343707852], 
            [0.060934671702573745, 0.49627307582066105], 
            [0.05226423163382673, 0.49726094768413664], 
            [0.04357787137382907, 0.4980973490458728], 
            [0.034878236872062617, 0.4987820251299121], 
            [0.026167978121471983, 0.4993147673772869], 
            [0.01744974835125043, 0.4996954135095478], 
            [0.0087262032186418, 0.49992384757819563], 
            [3.061616997868383E-17, 0.5], 
            [-0.008726203218641738, 0.49992384757819563], 
            [-0.01744974835125059, 0.4996954135095478], 
            [-0.02616797812147192, 0.4993147673772869], 
            [-0.034878236872062665, 0.4987820251299121], 
            [-0.04357787137382912, 0.4980973490458728], 
            [-0.052264231633826666, 0.49726094768413664], 
            [-0.06093467170257368, 0.49627307582066105], 
            [-0.06958655048003279, 0.4951340343707852], 
            [-0.07821723252011552, 0.49384417029756883], 
            [-0.08682408883346515, 0.49240387650610407], 
            [-0.0954044976882724, 0.490813591723832], 
            [-0.10395584540887956, 0.48907380036690284], 
            [-0.11247552717193263, 0.48718503239261757], 
            [-0.12096094779983389, 0.4851478631379982], 
            [-0.12940952255126043, 0.48296291314453416], 
            [-0.13781867790849953, 0.48063084796915945], 
            [-0.14618585236136833, 0.4781523779815178], 
            [-0.15450849718747367, 0.4755282581475768], 
            [-0.1627840772285784, 0.47275928779965837], 
            [-0.17101007166283436, 0.4698463103929542], 
            [-0.17918397477265013, 0.46679021324860087], 
            [-0.18730329670795604, 0.4635919272833937], 
            [-0.1953655642446368, 0.4602524267262202], 
            [-0.20336832153790005, 0.4567727288213005], 
            [-0.21130913087034986, 0.4531538935183249], 
            [-0.21918557339453876, 0.44939702314958346], 
            [-0.22699524986977337, 0.44550326209418395], 
            [-0.23473578139294526, 0.4414737964294635], 
            [-0.2424048101231685, 0.43730985356969787], 
            [-0.2500000000000001, 0.4330127018922193], 
            [-0.25751903745502713, 0.42858365035105617], 
            [-0.2649596321166024, 0.42402404807821303], 
            [-0.27231951750751354, 0.419335283972712], 
            [-0.27959645173537334, 0.41451878627752087], 
            [-0.2867882181755229, 0.409576022144496], 
            [-0.2938926261462365, 0.4045084971874737], 
            [-0.3009075115760242, 0.39931775502364636], 
            [-0.30783073766282915, 0.394005376803361], 
            [-0.31466019552491864, 0.3885729807284855], 
            [-0.3213938048432697, 0.383022221559489], 
            [-0.32802951449525375, 0.3773547901113859], 
            [-0.3345653031794291, 0.3715724127386971], 
            [-0.3409991800312492, 0.3656768508095853], 
            [-0.3473291852294987, 0.35966990016932554], 
            [-0.35355339059327373, 0.3535533905932738], 
            [-0.3596699001693255, 0.34732918522949874], 
            [-0.36567685080958523, 0.34099918003124924], 
            [-0.3715724127386972, 0.334565303179429], 
            [-0.377354790111386, 0.32802951449525364], 
            [-0.38302222155948895, 0.32139380484326974], 
            [-0.38857298072848545, 0.3146601955249187], 
            [-0.39400537680336106, 0.30783073766282903], 
            [-0.39931775502364647, 0.3009075115760241], 
            [-0.40450849718747367, 0.2938926261462366], 
            [-0.40957602214449595, 0.28678821817552297], 
            [-0.4145187862775208, 0.27959645173537345], 
            [-0.41933528397271197, 0.27231951750751365], 
            [-0.424024048078213, 0.26495963211660245], 
            [-0.4285836503510562, 0.257519037455027], 
            [-0.43301270189221935, 0.24999999999999997], 
            [-0.43730985356969787, 0.24240481012316858], 
            [-0.4414737964294635, 0.23473578139294535], 
            [-0.4455032620941839, 0.22699524986977343], 
            [-0.4493970231495835, 0.21918557339453865], 
            [-0.45315389351832497, 0.21130913087034975], 
            [-0.4567727288213005, 0.20336832153790002], 
            [-0.46025242672622013, 0.19536556424463689], 
            [-0.46359192728339366, 0.18730329670795612], 
            [-0.46679021324860087, 0.1791839747726501], 
            [-0.4698463103929542, 0.17101007166283422], 
            [-0.4727592877996584, 0.1627840772285783], 
            [-0.47552825814757677, 0.15450849718747375], 
            [-0.4781523779815177, 0.14618585236136852], 
            [-0.48063084796915945, 0.1378186779084996], 
            [-0.48296291314453416, 0.1294095225512603], 
            [-0.48514786313799824, 0.12096094779983387], 
            [-0.48718503239261757, 0.1124755271719326], 
            [-0.48907380036690284, 0.10395584540887966], 
            [-0.490813591723832, 0.09540449768827249], 
            [-0.49240387650610407, 0.08682408883346514], 
            [-0.49384417029756883, 0.07821723252011549], 
            [-0.4951340343707852, 0.06958655048003266], 
            [-0.49627307582066105, 0.06093467170257377], 
            [-0.49726094768413664, 0.05226423163382687], 
            [-0.4980973490458728, 0.0435778713738291], 
            [-0.4987820251299121, 0.03487823687206254], 
            [-0.4993147673772869, 0.026167978121471903], 
            [-0.4996954135095478, 0.01744974835125057], 
            [-0.49992384757819563, 0.00872620321864172], 
            [-0.5, 6.123233995736766E-17], 
            [-0.49992384757819563, -0.008726203218641596], 
            [-0.4996954135095478, -0.01744974835125045], 
            [-0.49931476737728697, -0.026167978121471782], 
            [-0.4987820251299121, -0.03487823687206286], 
            [-0.4980973490458728, -0.043577871373829194], 
            [-0.49726094768413664, -0.05226423163382675], 
            [-0.496273075820661, -0.06093467170257388], 
            [-0.4951340343707852, -0.06958655048003276], 
            [-0.4938441702975689, -0.07821723252011537], 
            [-0.492403876506104, -0.08682408883346523], 
            [-0.490813591723832, -0.09540449768827236], 
            [-0.48907380036690284, -0.10395584540887953], 
            [-0.4871850323926176, -0.11247552717193249], 
            [-0.4851478631379983, -0.12096094779983375], 
            [-0.4829629131445341, -0.1294095225512606], 
            [-0.4806308479691594, -0.13781867790849972], 
            [-0.4781523779815177, -0.14618585236136838], 
            [-0.4755282581475767, -0.15450849718747386], 
            [-0.47275928779965837, -0.16278407722857838], 
            [-0.4698463103929542, -0.17101007166283433], 
            [-0.4667902132486008, -0.17918397477265022], 
            [-0.4635919272833937, -0.187303296707956], 
            [-0.46025242672622024, -0.19536556424463677], 
            [-0.45677272882130054, -0.2033683215378999], 
            [-0.453153893518325, -0.21130913087034964], 
            [-0.4493970231495834, -0.21918557339453892], 
            [-0.4455032620941839, -0.22699524986977354], 
            [-0.44147379642946344, -0.23473578139294543], 
            [-0.4373098535696978, -0.24240481012316867], 
            [-0.4330127018922193, -0.25000000000000006], 
            [-0.42858365035105617, -0.2575190374550271], 
            [-0.42402404807821303, -0.2649596321166024], 
            [-0.419335283972712, -0.27231951750751354], 
            [-0.4145187862775209, -0.27959645173537334], 
            [-0.409576022144496, -0.2867882181755229], 
            [-0.4045084971874737, -0.2938926261462365], 
            [-0.3993177550236465, -0.300907511576024], 
            [-0.3940053768033609, -0.30783073766282926], 
            [-0.3885729807284854, -0.3146601955249188], 
            [-0.38302222155948906, -0.3213938048432696], 
            [-0.37735479011138595, -0.3280295144952537], 
            [-0.3715724127386971, -0.3345653031794291], 
            [-0.3656768508095853, -0.3409991800312492], 
            [-0.35966990016932554, -0.3473291852294987], 
            [-0.35355339059327384, -0.35355339059327373], 
            [-0.34732918522949874, -0.35966990016932543], 
            [-0.3409991800312493, -0.36567685080958523], 
            [-0.33456530317942923, -0.371572412738697], 
            [-0.32802951449525347, -0.3773547901113861], 
            [-0.3213938048432694, -0.38302222155948923], 
            [-0.31466019552491853, -0.38857298072848556], 
            [-0.30783073766282903, -0.39400537680336106], 
            [-0.30090751157602413, -0.3993177550236464], 
            [-0.2938926261462366, -0.40450849718747367], 
            [-0.2867882181755232, -0.4095760221444958], 
            [-0.2795964517353736, -0.4145187862775207], 
            [-0.2723195175075135, -0.419335283972712], 
            [-0.2649596321166025, -0.424024048078213], 
            [-0.25751903745502724, -0.42858365035105606], 
            [-0.2499999999999998, -0.4330127018922194], 
            [-0.24240481012316842, -0.437309853569698], 
            [-0.23473578139294538, -0.4414737964294635], 
            [-0.22699524986977346, -0.4455032620941839], 
            [-0.21918557339453887, -0.4493970231495834], 
            [-0.21130913087034958, -0.453153893518325], 
            [-0.20336832153790005, -0.4567727288213005], 
            [-0.1953655642446369, -0.46025242672622013], 
            [-0.18730329670795615, -0.46359192728339366], 
            [-0.17918397477265036, -0.4667902132486008], 
            [-0.1710100716628347, -0.4698463103929541], 
            [-0.16278407722857832, -0.4727592877996584], 
            [-0.15450849718747378, -0.47552825814757677], 
            [-0.1461858523613681, -0.47815237798151783], 
            [-0.13781867790849944, -0.48063084796915945], 
            [-0.12940952255126031, -0.48296291314453416], 
            [-0.12096094779983389, -0.4851478631379982], 
            [-0.11247552717193263, -0.48718503239261757], 
            [-0.1039558454088799, -0.48907380036690273], 
            [-0.0954044976882723, -0.490813591723832], 
            [-0.08682408883346517, -0.492403876506104], 
            [-0.07821723252011552, -0.49384417029756883], 
            [-0.06958655048003247, -0.4951340343707852], 
            [-0.060934671702573585, -0.49627307582066105], 
            [-0.05226423163382668, -0.49726094768413664], 
            [-0.043577871373829125, -0.4980973490458728], 
            [-0.03487823687206279, -0.4987820251299121], 
            [-0.026167978121471713, -0.49931476737728697], 
            [-0.01744974835125038, -0.4996954135095478], 
            [-0.008726203218641749, -0.49992384757819563], 
            [-9.184850993605148E-17, -0.5], 
            [0.008726203218641565, -0.49992384757819563], 
            [0.017449748351250197, -0.4996954135095478], 
            [0.026167978121471973, -0.4993147673772869], 
            [0.03487823687206261, -0.4987820251299121], 
            [0.04357787137382939, -0.4980973490458728], 
            [0.05226423163382694, -0.49726094768413664], 
            [0.06093467170257384, -0.496273075820661], 
            [0.06958655048003273, -0.4951340343707852], 
            [0.07821723252011534, -0.4938441702975689], 
            [0.08682408883346499, -0.49240387650610407], 
            [0.09540449768827212, -0.490813591723832], 
            [0.10395584540887971, -0.48907380036690284], 
            [0.11247552717193246, -0.4871850323926176], 
            [0.12096094779983416, -0.4851478631379982], 
            [0.12940952255126056, -0.4829629131445341], 
            [0.1378186779084997, -0.4806308479691594], 
            [0.14618585236136836, -0.4781523779815178], 
            [0.15450849718747361, -0.4755282581475768], 
            [0.16278407722857816, -0.4727592877996585], 
            [0.1710100716628345, -0.46984631039295416], 
            [0.1791839747726502, -0.46679021324860087], 
            [0.18730329670795598, -0.4635919272833937], 
            [0.19536556424463675, -0.46025242672622024], 
            [0.20336832153789988, -0.45677272882130054], 
            [0.2113091308703498, -0.4531538935183249], 
            [0.2191855733945387, -0.4493970231495835], 
            [0.22699524986977332, -0.445503262094184], 
            [0.2347357813929456, -0.4414737964294634], 
            [0.24240481012316864, -0.4373098535696978], 
            [0.25000000000000006, -0.4330127018922193], 
            [0.2575190374550271, -0.42858365035105617], 
            [0.26495963211660234, -0.42402404807821303], 
            [0.2723195175075133, -0.41933528397271214], 
            [0.2795964517353735, -0.4145187862775208], 
            [0.286788218175523, -0.4095760221444959], 
            [0.29389262614623646, -0.4045084971874738], 
            [0.30090751157602436, -0.3993177550236463], 
            [0.30783073766282926, -0.3940053768033609], 
            [0.31466019552491875, -0.3885729807284854], 
            [0.3213938048432696, -0.38302222155948906], 
            [0.3280295144952535, -0.3773547901113861], 
            [0.33456530317942923, -0.371572412738697], 
            [0.3409991800312493, -0.3656768508095852], 
            [0.3473291852294986, -0.35966990016932554], 
            [0.3535533905932737, -0.35355339059327384], 
            [0.35966990016932543, -0.3473291852294988], 
            [0.36567685080958506, -0.34099918003124946], 
            [0.3715724127386971, -0.33456530317942906], 
            [0.37735479011138595, -0.3280295144952537], 
            [0.3830222215594892, -0.32139380484326946], 
            [0.38857298072848556, -0.3146601955249186], 
            [0.394005376803361, -0.3078307376628291], 
            [0.3993177550236464, -0.30090751157602413], 
            [0.40450849718747367, -0.2938926261462367], 
            [0.4095760221444958, -0.28678821817552325], 
            [0.4145187862775207, -0.2795964517353737], 
            [0.419335283972712, -0.2723195175075135], 
            [0.4240240480782129, -0.2649596321166025], 
            [0.4285836503510563, -0.25751903745502686], 
            [0.4330127018922194, -0.24999999999999983], 
            [0.4373098535696979, -0.24240481012316845], 
            [0.4414737964294635, -0.2347357813929454], 
            [0.4455032620941839, -0.22699524986977349], 
            [0.4493970231495834, -0.2191855733945389], 
            [0.453153893518325, -0.2113091308703496], 
            [0.4567727288213005, -0.20336832153790008], 
            [0.46025242672622013, -0.19536556424463694], 
            [0.46359192728339366, -0.18730329670795617], 
            [0.4667902132486008, -0.17918397477265038], 
            [0.4698463103929542, -0.1710100716628343], 
            [0.4727592877996584, -0.16278407722857835], 
            [0.47552825814757677, -0.1545084971874738], 
            [0.4781523779815178, -0.14618585236136813], 
            [0.48063084796915945, -0.13781867790849947], 
            [0.48296291314453416, -0.12940952255126034], 
            [0.4851478631379982, -0.12096094779983393], 
            [0.48718503239261757, -0.11247552717193267], 
            [0.48907380036690273, -0.10395584540887993], 
            [0.490813591723832, -0.09540449768827233], 
            [0.492403876506104, -0.0868240888334652], 
            [0.4938441702975689, -0.07821723252011512], 
            [0.4951340343707852, -0.0695865504800325], 
            [0.49627307582066105, -0.06093467170257361], 
            [0.49726094768413664, -0.05226423163382671], 
            [0.4980973490458728, -0.04357787137382916], 
            [0.4987820251299121, -0.03487823687206282], 
            [0.49931476737728697, -0.02616797812147174], 
            [0.4996954135095478, -0.017449748351250412], 
            [0.49992384757819563, -0.00872620321864178]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359]
        ]
    );
}

module M662()
{
    polygon
    (
        points =
        [
            [0.5, 0.0], 
            [0.49759236333609846, 0.0490085701647803], 
            [0.4903926402016152, 0.09754516100806412], 
            [0.4784701678661044, 0.14514233862723117], 
            [0.46193976625564337, 0.1913417161825449], 
            [0.4409606321741775, 0.23569836841299882], 
            [0.4157348061512726, 0.2777851165098011], 
            [0.3865052266813685, 0.31719664208182274], 
            [0.3535533905932738, 0.35355339059327373], 
            [0.31719664208182274, 0.38650522668136844], 
            [0.27778511650980114, 0.4157348061512726], 
            [0.2356983684129989, 0.44096063217417747], 
            [0.19134171618254492, 0.46193976625564337], 
            [0.14514233862723117, 0.4784701678661044], 
            [0.09754516100806417, 0.4903926402016152], 
            [0.049008570164780385, 0.49759236333609846], 
            [3.061616997868383E-17, 0.5], 
            [-0.04900857016478032, 0.49759236333609846], 
            [-0.0975451610080641, 0.4903926402016152], 
            [-0.14514233862723108, 0.47847016786610447], 
            [-0.19134171618254486, 0.46193976625564337], 
            [-0.23569836841299885, 0.4409606321741775], 
            [-0.277785116509801, 0.4157348061512727], 
            [-0.3171966420818227, 0.38650522668136855], 
            [-0.35355339059327373, 0.3535533905932738], 
            [-0.3865052266813685, 0.31719664208182274], 
            [-0.4157348061512727, 0.2777851165098011], 
            [-0.44096063217417747, 0.23569836841299893], 
            [-0.46193976625564337, 0.19134171618254495], 
            [-0.4784701678661044, 0.1451423386272312], 
            [-0.4903926402016152, 0.0975451610080643], 
            [-0.49759236333609846, 0.04900857016478041], 
            [-0.5, 6.123233995736766E-17], 
            [-0.49759236333609846, -0.049008570164780295], 
            [-0.4903926402016152, -0.09754516100806418], 
            [-0.47847016786610447, -0.14514233862723105], 
            [-0.46193976625564337, -0.1913417161825448], 
            [-0.4409606321741775, -0.23569836841299882], 
            [-0.41573480615127273, -0.277785116509801], 
            [-0.38650522668136855, -0.31719664208182263], 
            [-0.35355339059327384, -0.35355339059327373], 
            [-0.31719664208182297, -0.38650522668136833], 
            [-0.2777851165098011, -0.4157348061512726], 
            [-0.23569836841299896, -0.44096063217417747], 
            [-0.19134171618254517, -0.46193976625564326], 
            [-0.14514233862723122, -0.4784701678661044], 
            [-0.09754516100806433, -0.4903926402016152], 
            [-0.049008570164780225, -0.49759236333609846], 
            [-9.184850993605148E-17, -0.5], 
            [0.049008570164780045, -0.49759236333609846], 
            [0.09754516100806415, -0.4903926402016152], 
            [0.14514233862723103, -0.47847016786610447], 
            [0.191341716182545, -0.4619397662556433], 
            [0.2356983684129988, -0.4409606321741775], 
            [0.2777851165098009, -0.41573480615127273], 
            [0.3171966420818228, -0.38650522668136844], 
            [0.3535533905932737, -0.35355339059327384], 
            [0.3865052266813683, -0.31719664208182297], 
            [0.4157348061512726, -0.2777851165098011], 
            [0.4409606321741774, -0.23569836841299896], 
            [0.46193976625564326, -0.1913417161825452], 
            [0.4784701678661044, -0.14514233862723125], 
            [0.49039264020161516, -0.09754516100806436], 
            [0.49759236333609846, -0.04900857016478025]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63]
        ]
    );
}

module M8()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}
